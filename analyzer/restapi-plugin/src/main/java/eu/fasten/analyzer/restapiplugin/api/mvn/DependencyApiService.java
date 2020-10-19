package eu.fasten.analyzer.restapiplugin.api.mvn;

import javax.ws.rs.core.Response;

public interface DependencyApiService {

    Response getPackageDependencies(String package_name,
                                    String package_version,
                                    short offset,
                                    short limit);
}
