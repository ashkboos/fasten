/*
 * This file is generated by jOOQ.
 */
package eu.fasten.analyzer.metadataplugin.db.codegen.tables;


import eu.fasten.analyzer.metadataplugin.db.codegen.Indexes;
import eu.fasten.analyzer.metadataplugin.db.codegen.Keys;
import eu.fasten.analyzer.metadataplugin.db.codegen.Public;
import eu.fasten.analyzer.metadataplugin.db.codegen.tables.records.PackageVersionsRecord;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.JSONB;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row6;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.3"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class PackageVersions extends TableImpl<PackageVersionsRecord> {

    private static final long serialVersionUID = -1520119248;

    /**
     * The reference instance of <code>public.package_versions</code>
     */
    public static final PackageVersions PACKAGE_VERSIONS = new PackageVersions();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<PackageVersionsRecord> getRecordType() {
        return PackageVersionsRecord.class;
    }

    /**
     * The column <code>public.package_versions.id</code>.
     */
    public final TableField<PackageVersionsRecord, Long> ID = createField(DSL.name("id"), org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('package_versions_id_seq'::regclass)", org.jooq.impl.SQLDataType.BIGINT)), this, "");

    /**
     * The column <code>public.package_versions.package_id</code>.
     */
    public final TableField<PackageVersionsRecord, Long> PACKAGE_ID = createField(DSL.name("package_id"), org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.package_versions.version</code>.
     */
    public final TableField<PackageVersionsRecord, String> VERSION = createField(DSL.name("version"), org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>public.package_versions.cg_generator</code>.
     */
    public final TableField<PackageVersionsRecord, String> CG_GENERATOR = createField(DSL.name("cg_generator"), org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>public.package_versions.created_at</code>.
     */
    public final TableField<PackageVersionsRecord, Timestamp> CREATED_AT = createField(DSL.name("created_at"), org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

    /**
     * The column <code>public.package_versions.metadata</code>.
     */
    public final TableField<PackageVersionsRecord, JSONB> METADATA = createField(DSL.name("metadata"), org.jooq.impl.SQLDataType.JSONB, this, "");

    /**
     * Create a <code>public.package_versions</code> table reference
     */
    public PackageVersions() {
        this(DSL.name("package_versions"), null);
    }

    /**
     * Create an aliased <code>public.package_versions</code> table reference
     */
    public PackageVersions(String alias) {
        this(DSL.name(alias), PACKAGE_VERSIONS);
    }

    /**
     * Create an aliased <code>public.package_versions</code> table reference
     */
    public PackageVersions(Name alias) {
        this(alias, PACKAGE_VERSIONS);
    }

    private PackageVersions(Name alias, Table<PackageVersionsRecord> aliased) {
        this(alias, aliased, null);
    }

    private PackageVersions(Name alias, Table<PackageVersionsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> PackageVersions(Table<O> child, ForeignKey<O, PackageVersionsRecord> key) {
        super(child, key, PACKAGE_VERSIONS);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.PACKAGE_VERSIONS_PKEY);
    }

    @Override
    public Identity<PackageVersionsRecord, Long> getIdentity() {
        return Keys.IDENTITY_PACKAGE_VERSIONS;
    }

    @Override
    public UniqueKey<PackageVersionsRecord> getPrimaryKey() {
        return Keys.PACKAGE_VERSIONS_PKEY;
    }

    @Override
    public List<UniqueKey<PackageVersionsRecord>> getKeys() {
        return Arrays.<UniqueKey<PackageVersionsRecord>>asList(Keys.PACKAGE_VERSIONS_PKEY);
    }

    @Override
    public List<ForeignKey<PackageVersionsRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<PackageVersionsRecord, ?>>asList(Keys.PACKAGE_VERSIONS__PACKAGE_VERSIONS_PACKAGE_ID_FKEY);
    }

    public Packages packages() {
        return new Packages(this, Keys.PACKAGE_VERSIONS__PACKAGE_VERSIONS_PACKAGE_ID_FKEY);
    }

    @Override
    public PackageVersions as(String alias) {
        return new PackageVersions(DSL.name(alias), this);
    }

    @Override
    public PackageVersions as(Name alias) {
        return new PackageVersions(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public PackageVersions rename(String name) {
        return new PackageVersions(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public PackageVersions rename(Name name) {
        return new PackageVersions(name, null);
    }

    // -------------------------------------------------------------------------
    // Row6 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row6<Long, Long, String, String, Timestamp, JSONB> fieldsRow() {
        return (Row6) super.fieldsRow();
    }
}
