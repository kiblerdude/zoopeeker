package org.kiblerdude.zoopeeker.resource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;

@Path("/")
@Produces(MediaType.TEXT_HTML)
public class RootResource {
	
	private static final Logger LOG = Logger.getLogger(RootResource.class);
	private static final String ROOT_PATH = "/";
	private static final String CHILD_PATH = "/%s";
	private final ZooKeeper zk;
	
	public RootResource(ZooKeeper zk) {
		this.zk = zk;
	}
	
    @GET
    public NodeView getRoot() {
    	Map<String, String> nodes = new HashMap<>();
    	
    	try {
	    	Boolean connected = zk.getState().isConnected();
	    	List<String> children = zk.getChildren(ROOT_PATH, false);
	    	
	    	for(String child : children) {
	    		nodes.put(child, String.format(CHILD_PATH, child));
	    	}
	    	
	        return new NodeView(connected, ROOT_PATH, nodes);
    	} catch (InterruptedException e) {
    		LOG.error(e.getMessage(), e);
    	} catch (KeeperException e) {
    		LOG.error(e.getMessage(), e);
		}
		return new NodeView(false, ROOT_PATH, nodes);
    }
}
