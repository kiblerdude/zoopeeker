package org.kiblerdude.zoopeeker;

import org.kiblerdude.zoopeeker.config.ZooKeeperConfiguration;

import com.bazaarvoice.dropwizard.assets.AssetsBundleConfiguration;
import com.bazaarvoice.dropwizard.assets.AssetsConfiguration;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yammer.dropwizard.config.Configuration;

public class ServiceConfiguration extends Configuration implements AssetsBundleConfiguration {

    @JsonProperty(value="zookeeper")
    private ZooKeeperConfiguration zooKeeper = new ZooKeeperConfiguration();

    @JsonProperty
    private final AssetsConfiguration assets = new AssetsConfiguration();    
    
    public ZooKeeperConfiguration getZooKeeperConfiguration() {
        return zooKeeper;
    }

    @Override
    public AssetsConfiguration getAssetsConfiguration() {
      return assets;
    }       
}
