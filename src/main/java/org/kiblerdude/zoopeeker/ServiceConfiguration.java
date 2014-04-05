package org.kiblerdude.zoopeeker;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.kiblerdude.zoopeeker.config.ZooKeeperConfiguration;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yammer.dropwizard.config.Configuration;

public class ServiceConfiguration extends Configuration {
    @Valid
    @NotNull
    @JsonProperty(value="zookeeper")
    private ZooKeeperConfiguration zooKeeper = new ZooKeeperConfiguration();

    public ZooKeeperConfiguration getZooKeeperConfiguration() {
        return zooKeeper;
    }
}
