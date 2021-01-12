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
import eu.fasten.core.data.metadatadb.codegen.tables.records.BinaryModuleContentsRecord;
import eu.fasten.core.data.metadatadb.codegen.tables.records.BinaryModulesRecord;
import eu.fasten.core.data.metadatadb.codegen.tables.records.CallablesRecord;
import eu.fasten.core.data.metadatadb.codegen.tables.records.DependenciesRecord;
import eu.fasten.core.data.metadatadb.codegen.tables.records.EdgesRecord;
import eu.fasten.core.data.metadatadb.codegen.tables.records.FilesRecord;
import eu.fasten.core.data.metadatadb.codegen.tables.records.ModuleContentsRecord;
import eu.fasten.core.data.metadatadb.codegen.tables.records.ModulesRecord;
import eu.fasten.core.data.metadatadb.codegen.tables.records.NamespacesRecord;
import eu.fasten.core.data.metadatadb.codegen.tables.records.PackageVersionsRecord;
import eu.fasten.core.data.metadatadb.codegen.tables.records.PackagesRecord;
import eu.fasten.core.data.metadatadb.codegen.tables.records.VirtualImplementationsRecord;

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

    public static final Identity<BinaryModulesRecord, Long> IDENTITY_BINARY_MODULES = Identities0.IDENTITY_BINARY_MODULES;
    public static final Identity<CallablesRecord, Long> IDENTITY_CALLABLES = Identities0.IDENTITY_CALLABLES;
    public static final Identity<FilesRecord, Long> IDENTITY_FILES = Identities0.IDENTITY_FILES;
    public static final Identity<ModulesRecord, Long> IDENTITY_MODULES = Identities0.IDENTITY_MODULES;
    public static final Identity<NamespacesRecord, Long> IDENTITY_NAMESPACES = Identities0.IDENTITY_NAMESPACES;
    public static final Identity<PackageVersionsRecord, Long> IDENTITY_PACKAGE_VERSIONS = Identities0.IDENTITY_PACKAGE_VERSIONS;
    public static final Identity<PackagesRecord, Long> IDENTITY_PACKAGES = Identities0.IDENTITY_PACKAGES;

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<BinaryModuleContentsRecord> UNIQUE_BINARY_MODULE_FILE = UniqueKeys0.UNIQUE_BINARY_MODULE_FILE;
    public static final UniqueKey<BinaryModulesRecord> BINARY_MODULES_PKEY = UniqueKeys0.BINARY_MODULES_PKEY;
    public static final UniqueKey<BinaryModulesRecord> UNIQUE_VERSION_NAME = UniqueKeys0.UNIQUE_VERSION_NAME;
    public static final UniqueKey<CallablesRecord> CALLABLES_PKEY = UniqueKeys0.CALLABLES_PKEY;
    public static final UniqueKey<CallablesRecord> UNIQUE_URI_CALL = UniqueKeys0.UNIQUE_URI_CALL;
    public static final UniqueKey<DependenciesRecord> UNIQUE_VERSION_DEPENDENCY_RANGE = UniqueKeys0.UNIQUE_VERSION_DEPENDENCY_RANGE;
    public static final UniqueKey<EdgesRecord> UNIQUE_SOURCE_TARGET = UniqueKeys0.UNIQUE_SOURCE_TARGET;
    public static final UniqueKey<FilesRecord> FILES_PKEY = UniqueKeys0.FILES_PKEY;
    public static final UniqueKey<FilesRecord> UNIQUE_VERSION_PATH = UniqueKeys0.UNIQUE_VERSION_PATH;
    public static final UniqueKey<ModuleContentsRecord> UNIQUE_MODULE_FILE = UniqueKeys0.UNIQUE_MODULE_FILE;
    public static final UniqueKey<ModulesRecord> MODULES_PKEY = UniqueKeys0.MODULES_PKEY;
    public static final UniqueKey<ModulesRecord> UNIQUE_VERSION_NAMESPACE = UniqueKeys0.UNIQUE_VERSION_NAMESPACE;
    public static final UniqueKey<NamespacesRecord> NAMESPACES_PKEY = UniqueKeys0.NAMESPACES_PKEY;
    public static final UniqueKey<PackageVersionsRecord> PACKAGE_VERSIONS_PKEY = UniqueKeys0.PACKAGE_VERSIONS_PKEY;
    public static final UniqueKey<PackageVersionsRecord> UNIQUE_PACKAGE_VERSION_GENERATOR = UniqueKeys0.UNIQUE_PACKAGE_VERSION_GENERATOR;
    public static final UniqueKey<PackagesRecord> PACKAGES_PKEY = UniqueKeys0.PACKAGES_PKEY;
    public static final UniqueKey<PackagesRecord> UNIQUE_PACKAGE_FORGE = UniqueKeys0.UNIQUE_PACKAGE_FORGE;
    public static final UniqueKey<VirtualImplementationsRecord> UNIQUE_VIRTUAL_IMPLEMENTATION = UniqueKeys0.UNIQUE_VIRTUAL_IMPLEMENTATION;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<BinaryModuleContentsRecord, BinaryModulesRecord> BINARY_MODULE_CONTENTS__BINARY_MODULE_CONTENTS_BINARY_MODULE_ID_FKEY = ForeignKeys0.BINARY_MODULE_CONTENTS__BINARY_MODULE_CONTENTS_BINARY_MODULE_ID_FKEY;
    public static final ForeignKey<BinaryModuleContentsRecord, FilesRecord> BINARY_MODULE_CONTENTS__BINARY_MODULE_CONTENTS_FILE_ID_FKEY = ForeignKeys0.BINARY_MODULE_CONTENTS__BINARY_MODULE_CONTENTS_FILE_ID_FKEY;
    public static final ForeignKey<BinaryModulesRecord, PackageVersionsRecord> BINARY_MODULES__BINARY_MODULES_PACKAGE_VERSION_ID_FKEY = ForeignKeys0.BINARY_MODULES__BINARY_MODULES_PACKAGE_VERSION_ID_FKEY;
    public static final ForeignKey<CallablesRecord, ModulesRecord> CALLABLES__CALLABLES_MODULE_ID_FKEY = ForeignKeys0.CALLABLES__CALLABLES_MODULE_ID_FKEY;
    public static final ForeignKey<DependenciesRecord, PackageVersionsRecord> DEPENDENCIES__DEPENDENCIES_PACKAGE_VERSION_ID_FKEY = ForeignKeys0.DEPENDENCIES__DEPENDENCIES_PACKAGE_VERSION_ID_FKEY;
    public static final ForeignKey<DependenciesRecord, PackagesRecord> DEPENDENCIES__DEPENDENCIES_DEPENDENCY_ID_FKEY = ForeignKeys0.DEPENDENCIES__DEPENDENCIES_DEPENDENCY_ID_FKEY;
    public static final ForeignKey<EdgesRecord, CallablesRecord> EDGES__EDGES_SOURCE_ID_FKEY = ForeignKeys0.EDGES__EDGES_SOURCE_ID_FKEY;
    public static final ForeignKey<EdgesRecord, CallablesRecord> EDGES__EDGES_TARGET_ID_FKEY = ForeignKeys0.EDGES__EDGES_TARGET_ID_FKEY;
    public static final ForeignKey<FilesRecord, PackageVersionsRecord> FILES__FILES_PACKAGE_VERSION_ID_FKEY = ForeignKeys0.FILES__FILES_PACKAGE_VERSION_ID_FKEY;
    public static final ForeignKey<ModuleContentsRecord, ModulesRecord> MODULE_CONTENTS__MODULE_CONTENTS_MODULE_ID_FKEY = ForeignKeys0.MODULE_CONTENTS__MODULE_CONTENTS_MODULE_ID_FKEY;
    public static final ForeignKey<ModuleContentsRecord, FilesRecord> MODULE_CONTENTS__MODULE_CONTENTS_FILE_ID_FKEY = ForeignKeys0.MODULE_CONTENTS__MODULE_CONTENTS_FILE_ID_FKEY;
    public static final ForeignKey<ModulesRecord, PackageVersionsRecord> MODULES__MODULES_PACKAGE_VERSION_ID_FKEY = ForeignKeys0.MODULES__MODULES_PACKAGE_VERSION_ID_FKEY;
    public static final ForeignKey<ModulesRecord, NamespacesRecord> MODULES__MODULES_NAMESPACE_ID_FKEY = ForeignKeys0.MODULES__MODULES_NAMESPACE_ID_FKEY;
    public static final ForeignKey<PackageVersionsRecord, PackagesRecord> PACKAGE_VERSIONS__PACKAGE_VERSIONS_PACKAGE_ID_FKEY = ForeignKeys0.PACKAGE_VERSIONS__PACKAGE_VERSIONS_PACKAGE_ID_FKEY;
    public static final ForeignKey<VirtualImplementationsRecord, PackageVersionsRecord> VIRTUAL_IMPLEMENTATIONS__VIRTUAL_IMPLEMENTATIONS_VIRTUAL_PACKAGE_VERSION_ID_FKEY = ForeignKeys0.VIRTUAL_IMPLEMENTATIONS__VIRTUAL_IMPLEMENTATIONS_VIRTUAL_PACKAGE_VERSION_ID_FKEY;
    public static final ForeignKey<VirtualImplementationsRecord, PackageVersionsRecord> VIRTUAL_IMPLEMENTATIONS__VIRTUAL_IMPLEMENTATIONS_PACKAGE_VERSION_ID_FKEY = ForeignKeys0.VIRTUAL_IMPLEMENTATIONS__VIRTUAL_IMPLEMENTATIONS_PACKAGE_VERSION_ID_FKEY;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Identities0 {
        public static Identity<BinaryModulesRecord, Long> IDENTITY_BINARY_MODULES = Internal.createIdentity(BinaryModules.BINARY_MODULES, BinaryModules.BINARY_MODULES.ID);
        public static Identity<CallablesRecord, Long> IDENTITY_CALLABLES = Internal.createIdentity(Callables.CALLABLES, Callables.CALLABLES.ID);
        public static Identity<FilesRecord, Long> IDENTITY_FILES = Internal.createIdentity(Files.FILES, Files.FILES.ID);
        public static Identity<ModulesRecord, Long> IDENTITY_MODULES = Internal.createIdentity(Modules.MODULES, Modules.MODULES.ID);
        public static Identity<NamespacesRecord, Long> IDENTITY_NAMESPACES = Internal.createIdentity(Namespaces.NAMESPACES, Namespaces.NAMESPACES.ID);
        public static Identity<PackageVersionsRecord, Long> IDENTITY_PACKAGE_VERSIONS = Internal.createIdentity(PackageVersions.PACKAGE_VERSIONS, PackageVersions.PACKAGE_VERSIONS.ID);
        public static Identity<PackagesRecord, Long> IDENTITY_PACKAGES = Internal.createIdentity(Packages.PACKAGES, Packages.PACKAGES.ID);
    }

    private static class UniqueKeys0 {
        public static final UniqueKey<BinaryModuleContentsRecord> UNIQUE_BINARY_MODULE_FILE = Internal.createUniqueKey(BinaryModuleContents.BINARY_MODULE_CONTENTS, "unique_binary_module_file", BinaryModuleContents.BINARY_MODULE_CONTENTS.BINARY_MODULE_ID, BinaryModuleContents.BINARY_MODULE_CONTENTS.FILE_ID);
        public static final UniqueKey<BinaryModulesRecord> BINARY_MODULES_PKEY = Internal.createUniqueKey(BinaryModules.BINARY_MODULES, "binary_modules_pkey", BinaryModules.BINARY_MODULES.ID);
        public static final UniqueKey<BinaryModulesRecord> UNIQUE_VERSION_NAME = Internal.createUniqueKey(BinaryModules.BINARY_MODULES, "unique_version_name", BinaryModules.BINARY_MODULES.PACKAGE_VERSION_ID, BinaryModules.BINARY_MODULES.NAME);
        public static final UniqueKey<CallablesRecord> CALLABLES_PKEY = Internal.createUniqueKey(Callables.CALLABLES, "callables_pkey", Callables.CALLABLES.ID);
        public static final UniqueKey<CallablesRecord> UNIQUE_URI_CALL = Internal.createUniqueKey(Callables.CALLABLES, "unique_uri_call", Callables.CALLABLES.MODULE_ID, Callables.CALLABLES.FASTEN_URI, Callables.CALLABLES.IS_INTERNAL_CALL);
        public static final UniqueKey<DependenciesRecord> UNIQUE_VERSION_DEPENDENCY_RANGE = Internal.createUniqueKey(Dependencies.DEPENDENCIES, "unique_version_dependency_range", Dependencies.DEPENDENCIES.PACKAGE_VERSION_ID, Dependencies.DEPENDENCIES.DEPENDENCY_ID, Dependencies.DEPENDENCIES.VERSION_RANGE);
        public static final UniqueKey<EdgesRecord> UNIQUE_SOURCE_TARGET = Internal.createUniqueKey(Edges.EDGES, "unique_source_target", Edges.EDGES.SOURCE_ID, Edges.EDGES.TARGET_ID);
        public static final UniqueKey<FilesRecord> FILES_PKEY = Internal.createUniqueKey(Files.FILES, "files_pkey", Files.FILES.ID);
        public static final UniqueKey<FilesRecord> UNIQUE_VERSION_PATH = Internal.createUniqueKey(Files.FILES, "unique_version_path", Files.FILES.PACKAGE_VERSION_ID, Files.FILES.PATH);
        public static final UniqueKey<ModuleContentsRecord> UNIQUE_MODULE_FILE = Internal.createUniqueKey(ModuleContents.MODULE_CONTENTS, "unique_module_file", ModuleContents.MODULE_CONTENTS.MODULE_ID, ModuleContents.MODULE_CONTENTS.FILE_ID);
        public static final UniqueKey<ModulesRecord> MODULES_PKEY = Internal.createUniqueKey(Modules.MODULES, "modules_pkey", Modules.MODULES.ID);
        public static final UniqueKey<ModulesRecord> UNIQUE_VERSION_NAMESPACE = Internal.createUniqueKey(Modules.MODULES, "unique_version_namespace", Modules.MODULES.PACKAGE_VERSION_ID, Modules.MODULES.NAMESPACE_ID);
        public static final UniqueKey<NamespacesRecord> NAMESPACES_PKEY = Internal.createUniqueKey(Namespaces.NAMESPACES, "namespaces_pkey", Namespaces.NAMESPACES.ID);
        public static final UniqueKey<PackageVersionsRecord> PACKAGE_VERSIONS_PKEY = Internal.createUniqueKey(PackageVersions.PACKAGE_VERSIONS, "package_versions_pkey", PackageVersions.PACKAGE_VERSIONS.ID);
        public static final UniqueKey<PackageVersionsRecord> UNIQUE_PACKAGE_VERSION_GENERATOR = Internal.createUniqueKey(PackageVersions.PACKAGE_VERSIONS, "unique_package_version_generator", PackageVersions.PACKAGE_VERSIONS.PACKAGE_ID, PackageVersions.PACKAGE_VERSIONS.VERSION, PackageVersions.PACKAGE_VERSIONS.CG_GENERATOR);
        public static final UniqueKey<PackagesRecord> PACKAGES_PKEY = Internal.createUniqueKey(Packages.PACKAGES, "packages_pkey", Packages.PACKAGES.ID);
        public static final UniqueKey<PackagesRecord> UNIQUE_PACKAGE_FORGE = Internal.createUniqueKey(Packages.PACKAGES, "unique_package_forge", Packages.PACKAGES.PACKAGE_NAME, Packages.PACKAGES.FORGE);
        public static final UniqueKey<VirtualImplementationsRecord> UNIQUE_VIRTUAL_IMPLEMENTATION = Internal.createUniqueKey(VirtualImplementations.VIRTUAL_IMPLEMENTATIONS, "unique_virtual_implementation", VirtualImplementations.VIRTUAL_IMPLEMENTATIONS.VIRTUAL_PACKAGE_VERSION_ID, VirtualImplementations.VIRTUAL_IMPLEMENTATIONS.PACKAGE_VERSION_ID);
    }

    private static class ForeignKeys0 {
        public static final ForeignKey<BinaryModuleContentsRecord, BinaryModulesRecord> BINARY_MODULE_CONTENTS__BINARY_MODULE_CONTENTS_BINARY_MODULE_ID_FKEY = Internal.createForeignKey(eu.fasten.core.data.metadatadb.codegen.Keys.BINARY_MODULES_PKEY, BinaryModuleContents.BINARY_MODULE_CONTENTS, "binary_module_contents__binary_module_contents_binary_module_id_fkey", BinaryModuleContents.BINARY_MODULE_CONTENTS.BINARY_MODULE_ID);
        public static final ForeignKey<BinaryModuleContentsRecord, FilesRecord> BINARY_MODULE_CONTENTS__BINARY_MODULE_CONTENTS_FILE_ID_FKEY = Internal.createForeignKey(eu.fasten.core.data.metadatadb.codegen.Keys.FILES_PKEY, BinaryModuleContents.BINARY_MODULE_CONTENTS, "binary_module_contents__binary_module_contents_file_id_fkey", BinaryModuleContents.BINARY_MODULE_CONTENTS.FILE_ID);
        public static final ForeignKey<BinaryModulesRecord, PackageVersionsRecord> BINARY_MODULES__BINARY_MODULES_PACKAGE_VERSION_ID_FKEY = Internal.createForeignKey(eu.fasten.core.data.metadatadb.codegen.Keys.PACKAGE_VERSIONS_PKEY, BinaryModules.BINARY_MODULES, "binary_modules__binary_modules_package_version_id_fkey", BinaryModules.BINARY_MODULES.PACKAGE_VERSION_ID);
        public static final ForeignKey<CallablesRecord, ModulesRecord> CALLABLES__CALLABLES_MODULE_ID_FKEY = Internal.createForeignKey(eu.fasten.core.data.metadatadb.codegen.Keys.MODULES_PKEY, Callables.CALLABLES, "callables__callables_module_id_fkey", Callables.CALLABLES.MODULE_ID);
        public static final ForeignKey<DependenciesRecord, PackageVersionsRecord> DEPENDENCIES__DEPENDENCIES_PACKAGE_VERSION_ID_FKEY = Internal.createForeignKey(eu.fasten.core.data.metadatadb.codegen.Keys.PACKAGE_VERSIONS_PKEY, Dependencies.DEPENDENCIES, "dependencies__dependencies_package_version_id_fkey", Dependencies.DEPENDENCIES.PACKAGE_VERSION_ID);
        public static final ForeignKey<DependenciesRecord, PackagesRecord> DEPENDENCIES__DEPENDENCIES_DEPENDENCY_ID_FKEY = Internal.createForeignKey(eu.fasten.core.data.metadatadb.codegen.Keys.PACKAGES_PKEY, Dependencies.DEPENDENCIES, "dependencies__dependencies_dependency_id_fkey", Dependencies.DEPENDENCIES.DEPENDENCY_ID);
        public static final ForeignKey<EdgesRecord, CallablesRecord> EDGES__EDGES_SOURCE_ID_FKEY = Internal.createForeignKey(eu.fasten.core.data.metadatadb.codegen.Keys.CALLABLES_PKEY, Edges.EDGES, "edges__edges_source_id_fkey", Edges.EDGES.SOURCE_ID);
        public static final ForeignKey<EdgesRecord, CallablesRecord> EDGES__EDGES_TARGET_ID_FKEY = Internal.createForeignKey(eu.fasten.core.data.metadatadb.codegen.Keys.CALLABLES_PKEY, Edges.EDGES, "edges__edges_target_id_fkey", Edges.EDGES.TARGET_ID);
        public static final ForeignKey<FilesRecord, PackageVersionsRecord> FILES__FILES_PACKAGE_VERSION_ID_FKEY = Internal.createForeignKey(eu.fasten.core.data.metadatadb.codegen.Keys.PACKAGE_VERSIONS_PKEY, Files.FILES, "files__files_package_version_id_fkey", Files.FILES.PACKAGE_VERSION_ID);
        public static final ForeignKey<ModuleContentsRecord, ModulesRecord> MODULE_CONTENTS__MODULE_CONTENTS_MODULE_ID_FKEY = Internal.createForeignKey(eu.fasten.core.data.metadatadb.codegen.Keys.MODULES_PKEY, ModuleContents.MODULE_CONTENTS, "module_contents__module_contents_module_id_fkey", ModuleContents.MODULE_CONTENTS.MODULE_ID);
        public static final ForeignKey<ModuleContentsRecord, FilesRecord> MODULE_CONTENTS__MODULE_CONTENTS_FILE_ID_FKEY = Internal.createForeignKey(eu.fasten.core.data.metadatadb.codegen.Keys.FILES_PKEY, ModuleContents.MODULE_CONTENTS, "module_contents__module_contents_file_id_fkey", ModuleContents.MODULE_CONTENTS.FILE_ID);
        public static final ForeignKey<ModulesRecord, PackageVersionsRecord> MODULES__MODULES_PACKAGE_VERSION_ID_FKEY = Internal.createForeignKey(eu.fasten.core.data.metadatadb.codegen.Keys.PACKAGE_VERSIONS_PKEY, Modules.MODULES, "modules__modules_package_version_id_fkey", Modules.MODULES.PACKAGE_VERSION_ID);
        public static final ForeignKey<ModulesRecord, NamespacesRecord> MODULES__MODULES_NAMESPACE_ID_FKEY = Internal.createForeignKey(eu.fasten.core.data.metadatadb.codegen.Keys.NAMESPACES_PKEY, Modules.MODULES, "modules__modules_namespace_id_fkey", Modules.MODULES.NAMESPACE_ID);
        public static final ForeignKey<PackageVersionsRecord, PackagesRecord> PACKAGE_VERSIONS__PACKAGE_VERSIONS_PACKAGE_ID_FKEY = Internal.createForeignKey(eu.fasten.core.data.metadatadb.codegen.Keys.PACKAGES_PKEY, PackageVersions.PACKAGE_VERSIONS, "package_versions__package_versions_package_id_fkey", PackageVersions.PACKAGE_VERSIONS.PACKAGE_ID);
        public static final ForeignKey<VirtualImplementationsRecord, PackageVersionsRecord> VIRTUAL_IMPLEMENTATIONS__VIRTUAL_IMPLEMENTATIONS_VIRTUAL_PACKAGE_VERSION_ID_FKEY = Internal.createForeignKey(eu.fasten.core.data.metadatadb.codegen.Keys.PACKAGE_VERSIONS_PKEY, VirtualImplementations.VIRTUAL_IMPLEMENTATIONS, "virtual_implementations__virtual_implementations_virtual_package_version_id_fkey", VirtualImplementations.VIRTUAL_IMPLEMENTATIONS.VIRTUAL_PACKAGE_VERSION_ID);
        public static final ForeignKey<VirtualImplementationsRecord, PackageVersionsRecord> VIRTUAL_IMPLEMENTATIONS__VIRTUAL_IMPLEMENTATIONS_PACKAGE_VERSION_ID_FKEY = Internal.createForeignKey(eu.fasten.core.data.metadatadb.codegen.Keys.PACKAGE_VERSIONS_PKEY, VirtualImplementations.VIRTUAL_IMPLEMENTATIONS, "virtual_implementations__virtual_implementations_package_version_id_fkey", VirtualImplementations.VIRTUAL_IMPLEMENTATIONS.PACKAGE_VERSION_ID);
    }
}
