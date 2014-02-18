package org.kiblerdude.zoopeeker.zk;

import org.apache.log4j.Logger;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

public class ZooKeeperMonitor implements Watcher {

	private static final Logger LOG = Logger.getLogger(ZooKeeperMonitor.class);
	
	public void process(WatchedEvent event) {
		LOG.debug(event.toString());
	}
}
