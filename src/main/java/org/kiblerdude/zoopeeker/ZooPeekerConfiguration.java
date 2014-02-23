package org.kiblerdude.zoopeeker;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yammer.dropwizard.config.Configuration;

public class ZooPeekerConfiguration extends Configuration {
    @NotEmpty
    @JsonProperty(value="zookeeper.host")
    private String host;

    @NotEmpty
    @JsonProperty(value="zookeeper.port")
    private String port;

    public String getHost() {
        return host;
    }

    public String getPort() {
        return port;
    }
}
