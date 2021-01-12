/*
 * This file is generated by jOOQ.
 */
package eu.fasten.core.data.metadatadb.codegen;


import eu.fasten.core.data.metadatadb.codegen.tables.BinaryModuleContents;
import eu.fasten.core.data.metadatadb.codegen.tables.BinaryModules;
import eu.fasten.core.data.metadatadb.codegen.tables.Callables;
import eu.fasten.core.data.metadatadb.codegen.tables.Dependencies;
import eu.fasten.core.data.metadatadb.codegen.tables.Edges;
import eu.fasten.core.data.metadatadb.codegen.tables.Files;
import eu.fasten.core.data.metadatadb.codegen.tables.ModuleContents;
import eu.fasten.core.data.metadatadb.codegen.tables.Modules;
import eu.fasten.core.data.metadatadb.codegen.tables.Namespaces;
import eu.fasten.core.data.metadatadb.codegen.tables.PackageVersions;
import eu.fasten.core.data.metadatadb.codegen.tables.Packages;
import eu.fasten.core.data.metadatadb.codegen.tables.VirtualImplementations;

import javax.annotation.processing.Generated;

import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.Internal;


/**
 * A class modelling indexes of tables of the <code>public</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.3"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index UNIQUE_BINARY_MODULE_FILE = Indexes0.UNIQUE_BINARY_MODULE_FILE;
    public static final Index BINARY_MODULES_PKEY = Indexes0.BINARY_MODULES_PKEY;
    public static final Index UNIQUE_VERSION_NAME = Indexes0.UNIQUE_VERSION_NAME;
    public static final Index CALLABLES_PKEY = Indexes0.CALLABLES_PKEY;
    public static final Index UNIQUE_URI_CALL = Indexes0.UNIQUE_URI_CALL;
    public static final Index UNIQUE_VERSION_DEPENDENCY_RANGE = Indexes0.UNIQUE_VERSION_DEPENDENCY_RANGE;
    public static final Index UNIQUE_SOURCE_TARGET = Indexes0.UNIQUE_SOURCE_TARGET;
    public static final Index FILES_PKEY = Indexes0.FILES_PKEY;
    public static final Index UNIQUE_VERSION_PATH = Indexes0.UNIQUE_VERSION_PATH;
    public static final Index UNIQUE_MODULE_FILE = Indexes0.UNIQUE_MODULE_FILE;
    public static final Index MODULES_PKEY = Indexes0.MODULES_PKEY;
    public static final Index UNIQUE_VERSION_NAMESPACE = Indexes0.UNIQUE_VERSION_NAMESPACE;
    public static final Index NAMESPACES_PKEY = Indexes0.NAMESPACES_PKEY;
    public static final Index UNIQUE_NAMEPACES = Indexes0.UNIQUE_NAMEPACES;
    public static final Index PACKAGE_VERSIONS_PKEY = Indexes0.PACKAGE_VERSIONS_PKEY;
    public static final Index UNIQUE_PACKAGE_VERSION_GENERATOR = Indexes0.UNIQUE_PACKAGE_VERSION_GENERATOR;
    public static final Index PACKAGES_PKEY = Indexes0.PACKAGES_PKEY;
    public static final Index UNIQUE_PACKAGE_FORGE = Indexes0.UNIQUE_PACKAGE_FORGE;
    public static final Index UNIQUE_VIRTUAL_IMPLEMENTATION = Indexes0.UNIQUE_VIRTUAL_IMPLEMENTATION;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Indexes0 {
        public static Index UNIQUE_BINARY_MODULE_FILE = Internal.createIndex("unique_binary_module_file", BinaryModuleContents.BINARY_MODULE_CONTENTS, new OrderField[] { BinaryModuleContents.BINARY_MODULE_CONTENTS.BINARY_MODULE_ID, BinaryModuleContents.BINARY_MODULE_CONTENTS.FILE_ID }, true);
        public static Index BINARY_MODULES_PKEY = Internal.createIndex("binary_modules_pkey", BinaryModules.BINARY_MODULES, new OrderField[] { BinaryModules.BINARY_MODULES.ID }, true);
        public static Index UNIQUE_VERSION_NAME = Internal.createIndex("unique_version_name", BinaryModules.BINARY_MODULES, new OrderField[] { BinaryModules.BINARY_MODULES.PACKAGE_VERSION_ID, BinaryModules.BINARY_MODULES.NAME }, true);
        public static Index CALLABLES_PKEY = Internal.createIndex("callables_pkey", Callables.CALLABLES, new OrderField[] { Callables.CALLABLES.ID }, true);
        public static Index UNIQUE_URI_CALL = Internal.createIndex("unique_uri_call", Callables.CALLABLES, new OrderField[] { Callables.CALLABLES.MODULE_ID, Callables.CALLABLES.FASTEN_URI, Callables.CALLABLES.IS_INTERNAL_CALL }, true);
        public static Index UNIQUE_VERSION_DEPENDENCY_RANGE = Internal.createIndex("unique_version_dependency_range", Dependencies.DEPENDENCIES, new OrderField[] { Dependencies.DEPENDENCIES.PACKAGE_VERSION_ID, Dependencies.DEPENDENCIES.DEPENDENCY_ID, Dependencies.DEPENDENCIES.VERSION_RANGE }, true);
        public static Index UNIQUE_SOURCE_TARGET = Internal.createIndex("unique_source_target", Edges.EDGES, new OrderField[] { Edges.EDGES.SOURCE_ID, Edges.EDGES.TARGET_ID }, true);
        public static Index FILES_PKEY = Internal.createIndex("files_pkey", Files.FILES, new OrderField[] { Files.FILES.ID }, true);
        public static Index UNIQUE_VERSION_PATH = Internal.createIndex("unique_version_path", Files.FILES, new OrderField[] { Files.FILES.PACKAGE_VERSION_ID, Files.FILES.PATH }, true);
        public static Index UNIQUE_MODULE_FILE = Internal.createIndex("unique_module_file", ModuleContents.MODULE_CONTENTS, new OrderField[] { ModuleContents.MODULE_CONTENTS.MODULE_ID, ModuleContents.MODULE_CONTENTS.FILE_ID }, true);
        public static Index MODULES_PKEY = Internal.createIndex("modules_pkey", Modules.MODULES, new OrderField[] { Modules.MODULES.ID }, true);
        public static Index UNIQUE_VERSION_NAMESPACE = Internal.createIndex("unique_version_namespace", Modules.MODULES, new OrderField[] { Modules.MODULES.PACKAGE_VERSION_ID, Modules.MODULES.NAMESPACE_ID }, true);
        public static Index NAMESPACES_PKEY = Internal.createIndex("namespaces_pkey", Namespaces.NAMESPACES, new OrderField[] { Namespaces.NAMESPACES.ID }, true);
        public static Index UNIQUE_NAMEPACES = Internal.createIndex("unique_namepaces", Namespaces.NAMESPACES, new OrderField[] { Namespaces.NAMESPACES.NAMESPACE }, true);
        public static Index PACKAGE_VERSIONS_PKEY = Internal.createIndex("package_versions_pkey", PackageVersions.PACKAGE_VERSIONS, new OrderField[] { PackageVersions.PACKAGE_VERSIONS.ID }, true);
        public static Index UNIQUE_PACKAGE_VERSION_GENERATOR = Internal.createIndex("unique_package_version_generator", PackageVersions.PACKAGE_VERSIONS, new OrderField[] { PackageVersions.PACKAGE_VERSIONS.PACKAGE_ID, PackageVersions.PACKAGE_VERSIONS.VERSION, PackageVersions.PACKAGE_VERSIONS.CG_GENERATOR }, true);
        public static Index PACKAGES_PKEY = Internal.createIndex("packages_pkey", Packages.PACKAGES, new OrderField[] { Packages.PACKAGES.ID }, true);
        public static Index UNIQUE_PACKAGE_FORGE = Internal.createIndex("unique_package_forge", Packages.PACKAGES, new OrderField[] { Packages.PACKAGES.PACKAGE_NAME, Packages.PACKAGES.FORGE }, true);
        public static Index UNIQUE_VIRTUAL_IMPLEMENTATION = Internal.createIndex("unique_virtual_implementation", VirtualImplementations.VIRTUAL_IMPLEMENTATIONS, new OrderField[] { VirtualImplementations.VIRTUAL_IMPLEMENTATIONS.VIRTUAL_PACKAGE_VERSION_ID, VirtualImplementations.VIRTUAL_IMPLEMENTATIONS.PACKAGE_VERSION_ID }, true);
    }
}
