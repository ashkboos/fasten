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

package eu.fasten.core.data;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.json.JSONObject;

/**
 * Each type is a class or an interface.
 */
public class JavaType {

    /**
     * The source file name of this type.
     */
    private final String sourceFileName;

    /**
     * Methods of this type and their unique ids (unique within the same artifact).
     */
    private final BiMap<Integer, JavaNode> methods;

    /**
     * Classes that this type inherits from in the order of instantiation.
     */
    private final LinkedList<FastenURI> superClasses;
    private final Map<String, JavaNode> definedMethods;

    public Map<String, JavaNode> getDefinedMethods() {
        return definedMethods;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        JavaType javaType = (JavaType) o;

        if (isFinal != javaType.isFinal) {
            return false;
        }
        if (sourceFileName != null ? !sourceFileName.equals(javaType.sourceFileName) :
            javaType.sourceFileName != null) {
            return false;
        }
        if (methods != null ? !methods.equals(javaType.methods) : javaType.methods != null) {
            return false;
        }
        if (superClasses != null ? !superClasses.equals(javaType.superClasses) :
            javaType.superClasses != null) {
            return false;
        }
        if (superInterfaces != null ? !superInterfaces.equals(javaType.superInterfaces) :
            javaType.superInterfaces != null) {
            return false;
        }
        return access != null ? access.equals(javaType.access) : javaType.access == null;
    }

    @Override
    public int hashCode() {
        int result = sourceFileName != null ? sourceFileName.hashCode() : 0;
        result = 31 * result + (methods != null ? methods.hashCode() : 0);
        result = 31 * result + (superClasses != null ? superClasses.hashCode() : 0);
        result = 31 * result + (superInterfaces != null ? superInterfaces.hashCode() : 0);
        result = 31 * result + (access != null ? access.hashCode() : 0);
        result = 31 * result + (isFinal ? 1 : 0);
        return result;
    }

    /**
     * Interfaces that this type or its super classes implement.
     */
    private final List<FastenURI> superInterfaces;

    /**
     * Access modifier of this JavaType.
     */
    private final String access;

    /**
     * Flag indicating if this JavaType is final.
     */
    private final boolean isFinal;

    /**
     * Creates {@link JavaType} for the given data.
     *  @param sourceFile      the name of this type's source file
     * @param methods         a map of methods in this type with their indexed by their ids.
     * @param defineds        a map of all defined methods of a type to their signature.
     * @param superClasses    classes that this type extends.
     * @param superInterfaces interfaces that this type implements.
     * @param access          access modifier
     * @param isFinal         true if the Type is final
     */
    public JavaType(final String sourceFile, final BiMap<Integer, JavaNode> methods,
                    final Map<String, JavaNode> defineds,
                    final LinkedList<FastenURI> superClasses,
                    final List<FastenURI> superInterfaces, final String access,
                    final boolean isFinal) {
        this.sourceFileName = sourceFile;
        this.methods = methods;
        this.definedMethods = defineds;
        this.superClasses = superClasses;
        this.superInterfaces = superInterfaces;
        this.access = access;
        this.isFinal = isFinal;
    }

    /**
     * Creates {@link JavaType} for the given JSONObject.
     *
     * @param type JSONObject of a type including its source file name, map of methods, super
     *             classes and super interfaces.
     */
    public JavaType(final JSONObject type) {
        this.sourceFileName = type.getString("sourceFile");

        final var methodsJson = type.getJSONObject("methods");
        this.methods = HashBiMap.create();
        this.definedMethods = new HashMap<>();
        for (final var methodKey : methodsJson.keySet()) {
            final var nodeJson = methodsJson.getJSONObject(methodKey);

            final var metadata = nodeJson.getJSONObject("metadata");
            final var uri = FastenURI.create(nodeJson.getString("uri"));
            final var node = new JavaNode(uri, metadata.toMap());
            this.methods.put(Integer.parseInt(methodKey), node);
            if (!metadata.isEmpty()) {
                if (metadata.getBoolean("defined")){
                    definedMethods.put(node.getSignature(), node);
                }
            }
        }

        final var superClassesJSON = type.getJSONArray("superClasses");
        this.superClasses = new LinkedList<>();
        final int numberOfSuperClasses = superClassesJSON.length();
        for (int i = 0; i < numberOfSuperClasses; i++) {
            this.superClasses.add(FastenURI.create(superClassesJSON.getString(i)));
        }

        final var superInterfacesJSON = type.getJSONArray("superInterfaces");
        this.superInterfaces = new ArrayList<>();
        final int numberOfSuperInterfaces = superInterfacesJSON.length();
        for (int i = 0; i < numberOfSuperInterfaces; i++) {
            this.superInterfaces.add(FastenURI.create(superInterfacesJSON.getString(i)));
        }
        this.access = type.getString("access");
        this.isFinal = type.getBoolean("final");
    }

    public String getSourceFileName() {
        return sourceFileName;
    }

    public Map<Integer, JavaNode> getMethods() {
        return this.methods;
    }

    public LinkedList<FastenURI> getSuperClasses() {
        return superClasses;
    }

    public List<FastenURI> getSuperInterfaces() {
        return superInterfaces;
    }

    public String getAccess() {
        return access;
    }

    public boolean isFinal() {
        return isFinal;
    }

    /**
     * Add a JavaNode to the list of methods of this {@link JavaType}.
     *
     * @param node new node to add
     * @param key  the key corresponding to this JavaNode
     * @return newly added method id, or an old id, of method already exists
     */
    public int addMethod(final JavaNode node, final int key) {
        if (this.methods.inverse().containsKey(node)) {
            return this.methods.inverse().get(node);
        } else {
            this.methods.put(key, node);
            return key;
        }
    }

    /**
     * Converts all the values of a given Map to String.
     *
     * @param map map of id-s and corresponding JavaNodes
     */
    public static Map<Integer, JSONObject> toMapOfString(final Map<Integer, JavaNode> map) {
        final Map<Integer, JSONObject> methods = new HashMap<>();
        for (final var entry : map.entrySet()) {
            final JSONObject node = new JSONObject();
            node.put("uri", entry.getValue().getUri());
            node.put("metadata", new JSONObject(entry.getValue().getMetadata()));
            methods.put(entry.getKey(), node);
        }
        return methods;
    }

    /**
     * Converts elements of a given list to String.
     *
     * @param list a list of elements to be converted
     */
    public static List<String> toListOfString(final List<?> list) {
        final List<String> result = new ArrayList<>();
        for (final var fastenURI : list) {
            result.add(fastenURI.toString());
        }
        return result;
    }

    /**
     * Get all defined methods.
     *
     * @param signature method signature
     * @return optional map of all defined methods
     */
    public Optional<Map.Entry<Integer, JavaNode>> getDefined(String signature) {
        return methods.entrySet()
                .stream()
                .filter(node -> (Boolean) node.getValue().metadata.get("defined"))
                .filter(node -> node.getValue().getSignature().equals(signature))
                .findAny();
    }

    /**
     * Converts this {@link JavaType} object to its JSON representation.
     *
     * @return the corresponding JSON representation.
     */
    public JSONObject toJSON() {
        final var result = new JSONObject();

        result.put("methods", toMapOfString(this.methods));
        result.put("superClasses", toListOfString(this.superClasses));
        result.put("superInterfaces", toListOfString(this.superInterfaces));
        result.put("sourceFile", this.sourceFileName);
        result.put("access", this.access);
        result.put("final", this.isFinal);

        return result;
    }

    @Override
    public String toString() {
        return "JavaType{"
                + "sourceFileName='" + sourceFileName + '\''
                + ", methods=" + methods
                + ", superClasses=" + superClasses
                + ", superInterfaces=" + superInterfaces
                + ", access=" + access
                + ", final=" + isFinal
                + '}';
    }
}
