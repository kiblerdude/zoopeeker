package org.kiblerdude.zoopeeker;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yammer.dropwizard.config.Configuration;

public class ZooPeekerConfiguration extends Configuration {
    @NotEmpty
    @JsonProperty
    private String host = "localhost";

    @NotEmpty
    @JsonProperty
    private String port = "2181";

    public String getHost() {
        return host;
    }

    public String getPort() {
        return port;
    }
}
