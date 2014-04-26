package org.kiblerdude.zoopeeker;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.zookeeper.ZooKeeper;
import org.kiblerdude.zoopeeker.config.ZooKeeperConfiguration;
import org.kiblerdude.zoopeeker.resource.NodeResource;
import org.kiblerdude.zoopeeker.zk.ZooKeeperMonitor;

import com.bazaarvoice.dropwizard.assets.ConfiguredAssetsBundle;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import com.yammer.dropwizard.views.ViewBundle;

public class ZooPeekerService extends Service<ServiceConfiguration> {

	private static final Logger LOG = Logger.getLogger(ZooPeekerService.class);
	private ZooKeeper zookeeper;

	public ZooPeekerService() {

	}

	@Override
	public void initialize(Bootstrap<ServiceConfiguration> bootstrap) {
		bootstrap.setName("zoopeeker");
		
		bootstrap.addBundle(new ViewBundle());
		bootstrap.addBundle(new ConfiguredAssetsBundle("/assets/", "/assets/"));
	}

	@Override
	public void run(ServiceConfiguration configuration, Environment environment) throws Exception {
		
		try {
			ZooKeeperConfiguration zkConfig = configuration.getZooKeeperConfiguration();
			String zkHost = zkConfig.getHost();
			String zkPort = zkConfig.getPort();
			String zkHostPort = String.format("%s:%s", zkHost, zkPort);
			
			LOG.info("Connecting to ZooKeeper " + zkHostPort);
			zookeeper = new ZooKeeper(zkHostPort, 3000, new ZooKeeperMonitor());
		} catch (IOException e) {
			LOG.error(e.getMessage(), e);
		}		
		
		environment.addHealthCheck(new ZooPeekerHealthCheck());
		environment.addResource(new NodeResource(zookeeper));
	}

	public static void main(String[] args) throws Exception {
		new ZooPeekerService().run(args);
	}
}
