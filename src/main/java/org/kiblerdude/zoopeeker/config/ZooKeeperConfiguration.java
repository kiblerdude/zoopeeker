package org.kiblerdude.zoopeeker.config;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yammer.dropwizard.config.Configuration;

public class ZooKeeperConfiguration extends Configuration {

    @JsonProperty(value="host")
    private String host;

    @JsonProperty(value="port")
    private String port; 

    public String getHost() {
        return host;
    }

    public String getPort() {
        return port;
    }
}
