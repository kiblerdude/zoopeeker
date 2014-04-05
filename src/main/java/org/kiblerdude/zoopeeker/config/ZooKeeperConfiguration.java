package org.kiblerdude.zoopeeker.config;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yammer.dropwizard.config.Configuration;

public class ZooKeeperConfiguration extends Configuration {
    @NotEmpty
    @JsonProperty(value="host")
    private String host;

    @NotEmpty
    @JsonProperty(value="port")
    private String port;

    public String getHost() {
        return host;
    }

    public String getPort() {
        return port;
    }
}
