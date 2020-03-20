/*
 * This file is generated by jOOQ.
 */
package eu.fasten.analyzer.metadataplugin.db.codegen;


import eu.fasten.analyzer.metadataplugin.db.codegen.tables.Callables;
import eu.fasten.analyzer.metadataplugin.db.codegen.tables.Dependencies;
import eu.fasten.analyzer.metadataplugin.db.codegen.tables.Edges;
import eu.fasten.analyzer.metadataplugin.db.codegen.tables.Files;
import eu.fasten.analyzer.metadataplugin.db.codegen.tables.PackageVersions;
import eu.fasten.analyzer.metadataplugin.db.codegen.tables.Packages;
import eu.fasten.analyzer.metadataplugin.db.codegen.tables.records.CallablesRecord;
import eu.fasten.analyzer.metadataplugin.db.codegen.tables.records.DependenciesRecord;
import eu.fasten.analyzer.metadataplugin.db.codegen.tables.records.EdgesRecord;
import eu.fasten.analyzer.metadataplugin.db.codegen.tables.records.FilesRecord;
import eu.fasten.analyzer.metadataplugin.db.codegen.tables.records.PackageVersionsRecord;
import eu.fasten.analyzer.metadataplugin.db.codegen.tables.records.PackagesRecord;

import javax.annotation.processing.Generated;

import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.UniqueKey;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables of 
 * the <code>public</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.3"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------

    public static final Identity<CallablesRecord, Long> IDENTITY_CALLABLES = Identities0.IDENTITY_CALLABLES;
    public static final Identity<FilesRecord, Long> IDENTITY_FILES = Identities0.IDENTITY_FILES;
    public static final Identity<PackageVersionsRecord, Long> IDENTITY_PACKAGE_VERSIONS = Identities0.IDENTITY_PACKAGE_VERSIONS;
    public static final Identity<PackagesRecord, Long> IDENTITY_PACKAGES = Identities0.IDENTITY_PACKAGES;

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<CallablesRecord> CALLABLES_PKEY = UniqueKeys0.CALLABLES_PKEY;
    public static final UniqueKey<FilesRecord> FILES_PKEY = UniqueKeys0.FILES_PKEY;
    public static final UniqueKey<PackageVersionsRecord> PACKAGE_VERSIONS_PKEY = UniqueKeys0.PACKAGE_VERSIONS_PKEY;
    public static final UniqueKey<PackagesRecord> PACKAGES_PKEY = UniqueKeys0.PACKAGES_PKEY;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<CallablesRecord, FilesRecord> CALLABLES__CALLABLES_FILE_ID_FKEY = ForeignKeys0.CALLABLES__CALLABLES_FILE_ID_FKEY;
    public static final ForeignKey<DependenciesRecord, PackageVersionsRecord> DEPENDENCIES__DEPENDENCIES_PACKAGE_ID_FKEY = ForeignKeys0.DEPENDENCIES__DEPENDENCIES_PACKAGE_ID_FKEY;
    public static final ForeignKey<DependenciesRecord, PackagesRecord> DEPENDENCIES__DEPENDENCIES_DEPENDENCY_ID_FKEY = ForeignKeys0.DEPENDENCIES__DEPENDENCIES_DEPENDENCY_ID_FKEY;
    public static final ForeignKey<EdgesRecord, CallablesRecord> EDGES__EDGES_SOURCE_ID_FKEY = ForeignKeys0.EDGES__EDGES_SOURCE_ID_FKEY;
    public static final ForeignKey<EdgesRecord, CallablesRecord> EDGES__EDGES_TARGET_ID_FKEY = ForeignKeys0.EDGES__EDGES_TARGET_ID_FKEY;
    public static final ForeignKey<FilesRecord, PackageVersionsRecord> FILES__FILES_PACKAGE_ID_FKEY = ForeignKeys0.FILES__FILES_PACKAGE_ID_FKEY;
    public static final ForeignKey<PackageVersionsRecord, PackagesRecord> PACKAGE_VERSIONS__PACKAGE_VERSIONS_PACKAGE_ID_FKEY = ForeignKeys0.PACKAGE_VERSIONS__PACKAGE_VERSIONS_PACKAGE_ID_FKEY;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Identities0 {
        public static Identity<CallablesRecord, Long> IDENTITY_CALLABLES = Internal.createIdentity(Callables.CALLABLES, Callables.CALLABLES.ID);
        public static Identity<FilesRecord, Long> IDENTITY_FILES = Internal.createIdentity(Files.FILES, Files.FILES.ID);
        public static Identity<PackageVersionsRecord, Long> IDENTITY_PACKAGE_VERSIONS = Internal.createIdentity(PackageVersions.PACKAGE_VERSIONS, PackageVersions.PACKAGE_VERSIONS.ID);
        public static Identity<PackagesRecord, Long> IDENTITY_PACKAGES = Internal.createIdentity(Packages.PACKAGES, Packages.PACKAGES.ID);
    }

    private static class UniqueKeys0 {
        public static final UniqueKey<CallablesRecord> CALLABLES_PKEY = Internal.createUniqueKey(Callables.CALLABLES, "callables_pkey", Callables.CALLABLES.ID);
        public static final UniqueKey<FilesRecord> FILES_PKEY = Internal.createUniqueKey(Files.FILES, "files_pkey", Files.FILES.ID);
        public static final UniqueKey<PackageVersionsRecord> PACKAGE_VERSIONS_PKEY = Internal.createUniqueKey(PackageVersions.PACKAGE_VERSIONS, "package_versions_pkey", PackageVersions.PACKAGE_VERSIONS.ID);
        public static final UniqueKey<PackagesRecord> PACKAGES_PKEY = Internal.createUniqueKey(Packages.PACKAGES, "packages_pkey", Packages.PACKAGES.ID);
    }

    private static class ForeignKeys0 {
        public static final ForeignKey<CallablesRecord, FilesRecord> CALLABLES__CALLABLES_FILE_ID_FKEY = Internal.createForeignKey(eu.fasten.analyzer.metadataplugin.db.codegen.Keys.FILES_PKEY, Callables.CALLABLES, "callables__callables_file_id_fkey", Callables.CALLABLES.FILE_ID);
        public static final ForeignKey<DependenciesRecord, PackageVersionsRecord> DEPENDENCIES__DEPENDENCIES_PACKAGE_ID_FKEY = Internal.createForeignKey(eu.fasten.analyzer.metadataplugin.db.codegen.Keys.PACKAGE_VERSIONS_PKEY, Dependencies.DEPENDENCIES, "dependencies__dependencies_package_id_fkey", Dependencies.DEPENDENCIES.PACKAGE_ID);
        public static final ForeignKey<DependenciesRecord, PackagesRecord> DEPENDENCIES__DEPENDENCIES_DEPENDENCY_ID_FKEY = Internal.createForeignKey(eu.fasten.analyzer.metadataplugin.db.codegen.Keys.PACKAGES_PKEY, Dependencies.DEPENDENCIES, "dependencies__dependencies_dependency_id_fkey", Dependencies.DEPENDENCIES.DEPENDENCY_ID);
        public static final ForeignKey<EdgesRecord, CallablesRecord> EDGES__EDGES_SOURCE_ID_FKEY = Internal.createForeignKey(eu.fasten.analyzer.metadataplugin.db.codegen.Keys.CALLABLES_PKEY, Edges.EDGES, "edges__edges_source_id_fkey", Edges.EDGES.SOURCE_ID);
        public static final ForeignKey<EdgesRecord, CallablesRecord> EDGES__EDGES_TARGET_ID_FKEY = Internal.createForeignKey(eu.fasten.analyzer.metadataplugin.db.codegen.Keys.CALLABLES_PKEY, Edges.EDGES, "edges__edges_target_id_fkey", Edges.EDGES.TARGET_ID);
        public static final ForeignKey<FilesRecord, PackageVersionsRecord> FILES__FILES_PACKAGE_ID_FKEY = Internal.createForeignKey(eu.fasten.analyzer.metadataplugin.db.codegen.Keys.PACKAGE_VERSIONS_PKEY, Files.FILES, "files__files_package_id_fkey", Files.FILES.PACKAGE_ID);
        public static final ForeignKey<PackageVersionsRecord, PackagesRecord> PACKAGE_VERSIONS__PACKAGE_VERSIONS_PACKAGE_ID_FKEY = Internal.createForeignKey(eu.fasten.analyzer.metadataplugin.db.codegen.Keys.PACKAGES_PKEY, PackageVersions.PACKAGE_VERSIONS, "package_versions__package_versions_package_id_fkey", PackageVersions.PACKAGE_VERSIONS.PACKAGE_ID);
    }
}
