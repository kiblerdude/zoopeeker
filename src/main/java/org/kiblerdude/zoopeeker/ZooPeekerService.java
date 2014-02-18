package org.kiblerdude.zoopeeker;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.zookeeper.ZooKeeper;
import org.kiblerdude.zoopeeker.resource.NodeResource;
import org.kiblerdude.zoopeeker.resource.RootResource;
import org.kiblerdude.zoopeeker.zk.ZooKeeperMonitor;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import com.yammer.dropwizard.views.ViewBundle;

public class ZooPeekerService extends Service<ZooPeekerConfiguration> {

	private static final Logger LOG = Logger.getLogger(ZooPeekerService.class);
	private ZooKeeper zookeeper;

	public ZooPeekerService() {

	}

	@Override
	public void initialize(Bootstrap<ZooPeekerConfiguration> bootstrap) {
		bootstrap.setName("zoopeeker");
		bootstrap.addBundle(new ViewBundle());

		try {
			LOG.debug("Connecting to ZooKeeper");
			zookeeper = new ZooKeeper("192.168.33.10:2181", 3000, new ZooKeeperMonitor());
		} catch (IOException e) {

		}
	}

	@Override
	public void run(ZooPeekerConfiguration configuration,
			Environment environment) throws Exception {
		LOG.debug("Adding Resources");
		environment.addHealthCheck(new ZooPeekerHealthCheck());
		environment.addResource(new RootResource(zookeeper));
		environment.addResource(new NodeResource(zookeeper));
	}

	public static void main(String[] args) throws Exception {
		new ZooPeekerService().run(args);
	}
}
