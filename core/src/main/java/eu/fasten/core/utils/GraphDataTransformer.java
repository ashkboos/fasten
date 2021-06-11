/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package eu.fasten.core.utils;

import eu.fasten.core.data.DirectedGraph;
import eu.fasten.core.data.graphdb.ExtendedGidGraph;
import eu.fasten.core.data.graphdb.RocksDao;
import eu.fasten.core.data.metadatadb.codegen.tables.Callables;
import eu.fasten.core.data.metadatadb.codegen.tables.Edges;
import eu.fasten.core.data.metadatadb.codegen.tables.PackageVersions;
import eu.fasten.core.data.metadatadb.codegen.tables.Packages;
import eu.fasten.core.dbconnectors.PostgresConnector;
import org.apache.commons.math3.util.Pair;
import org.jooq.DSLContext;
import org.rocksdb.RocksDBException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import picocli.CommandLine;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

@CommandLine.Command(name = "GraphDataTransformer")
public class GraphDataTransformer implements Runnable {

    private static final Logger logger = LoggerFactory.getLogger(GraphDataTransformer.class);

    @CommandLine.Option(names = {"-d", "--database"},
            paramLabel = "DB_URL",
            description = "Database URL for connection",
            defaultValue = "jdbc:postgresql:fasten_java")
    String dbUrl;

    @CommandLine.Option(names = {"-u", "--user"},
            paramLabel = "DB_USER",
            description = "Database user name",
            defaultValue = "postgres")
    String dbUser;

    @CommandLine.Option(names = {"-gd", "--graph-db"},
            paramLabel = "Dir",
            description = "The directory of the RocksDB instance")
    String graphDbPath;

    @CommandLine.Option(names = {"-ngd", "--new-graph-db"},
            paramLabel = "Dir",
            description = "The directory of the new RocksDB instance")
    String oldGraphDbPath;

    public static void main(String[] args) {
        final int exitCode = new CommandLine(new GraphDataTransformer()).execute(args);
        System.exit(exitCode);
    }

    @Override
    public void run() {
        RocksDao oldGraphDb;
        RocksDao newGraphDb;
        DSLContext metadataDb;
        try {
            oldGraphDb = new RocksDao(graphDbPath, true, true);
            newGraphDb = new RocksDao(oldGraphDbPath, false);
            metadataDb = PostgresConnector.getDSLContext(dbUrl, dbUser, true);
        } catch (RocksDBException | SQLException e) {
            logger.error("Could not setup connections to the database:", e);
            return;
        }
        var packageVersionIds = new HashSet<Long>();
        metadataDb.select(PackageVersions.PACKAGE_VERSIONS.ID).from(PackageVersions.PACKAGE_VERSIONS).fetch().forEach(r -> packageVersionIds.add(r.value1()));
        var packageVersions = new HashMap<Long, Pair<String, String>>();
        metadataDb.select(PackageVersions.PACKAGE_VERSIONS.ID, Packages.PACKAGES.PACKAGE_NAME, PackageVersions.PACKAGE_VERSIONS.VERSION)
                .from(Packages.PACKAGES).join(PackageVersions.PACKAGE_VERSIONS)
                .on(PackageVersions.PACKAGE_VERSIONS.PACKAGE_ID.eq(Packages.PACKAGES.ID))
                .where(PackageVersions.PACKAGE_VERSIONS.ID.in(packageVersionIds)).fetch()
                .forEach(r -> packageVersions.put(r.value1(), new Pair<>(r.value2(), r.value3())));
        for (var packageVersionId : packageVersionIds) {
            DirectedGraph oldGraphData;
            try {
                oldGraphData = oldGraphDb.getGraphData(packageVersionId);
            } catch (RocksDBException e) {
                logger.warn("Could not retrieve package version with id {}", packageVersionId);
                continue;
            }
            if (oldGraphData == null) {
                logger.warn("Directed graph with id {} is not found", packageVersionId);
                continue;
            }
            var callables = new HashSet<>(metadataDb.select(Callables.CALLABLES.ID, Callables.CALLABLES.MODULE_ID, Callables.CALLABLES.FASTEN_URI)
                    .from(Callables.CALLABLES).where(Callables.CALLABLES.ID.in(oldGraphData.nodes())).fetch());
            var edges = new HashSet<>(metadataDb.selectFrom(Edges.EDGES).where(Edges.EDGES.SOURCE_ID.in(oldGraphData.nodes())).fetch());
            edges.addAll(metadataDb.selectFrom(Edges.EDGES).where(Edges.EDGES.TARGET_ID.in(oldGraphData.nodes())).fetch());
            var gidToUriMap = new HashMap<Long, String>();
            callables.forEach(c -> gidToUriMap.put(c.value1(), c.value3()));
            var extendedGidGraph = new ExtendedGidGraph(packageVersionId,
                    packageVersions.get(packageVersionId).getFirst(),
                    packageVersions.get(packageVersionId).getSecond(),
                    new ArrayList<>(oldGraphData.nodes()),
                    oldGraphData.nodes().size() - oldGraphData.externalNodes().size(),
                    new ArrayList<>(edges),
                    gidToUriMap,
                    null);
            try {
                newGraphDb.saveToRocksDb(extendedGidGraph);
            } catch (IOException | RocksDBException e) {
                logger.error("Could not save the extended GID graph with ID {}", packageVersionId);
                continue;
            }
            logger.info("Successfully saved the new graph data with ID {}", packageVersionId);
        }
    }
}
