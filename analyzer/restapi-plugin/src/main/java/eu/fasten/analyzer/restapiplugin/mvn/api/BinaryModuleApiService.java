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

package eu.fasten.analyzer.restapiplugin.mvn.api;

import org.springframework.http.ResponseEntity;

public interface BinaryModuleApiService {

    ResponseEntity<String> getPackageBinaryModules(String package_name,
                                                   String package_version,
                                                   int offset,
                                                   int limit);

    ResponseEntity<String> getBinaryModuleMetadata(String package_name,
                                                   String package_version,
                                                   String binary_module,
                                                   int offset,
                                                   int limit);

    ResponseEntity<String> getBinaryModuleFiles(String package_name,
                                                String package_version,
                                                String binary_module,
                                                int offset,
                                                int limit);
}
