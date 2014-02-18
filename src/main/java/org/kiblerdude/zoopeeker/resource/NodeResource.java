package org.kiblerdude.zoopeeker.resource;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;

@Path("/{node}")
@Produces(MediaType.TEXT_HTML)
public class NodeResource {
	
	private static final Logger LOG = Logger.getLogger(NodeResource.class);
	private static final String ENCODING = "UTF-8";
	private static final String NODE_PATH = "/%s";
	private static final String CHILD_PATH = "/%s%%2F%s";
	private final ZooKeeper zk;
	
	public NodeResource(ZooKeeper zk) {
		this.zk = zk;
	}
	
    @GET
    public NodeView getNode(@PathParam("node") String node) {
    	Map<String, String> nodes = new HashMap<>();
    	try {
    		String path = String.format(NODE_PATH, node);
	    	Boolean connected = zk.getState().isConnected();
	    	List<String> children = zk.getChildren(path, false);
	    	
	    	String encodedNode = URLEncoder.encode(node, ENCODING);
	    	
	    	for (String child : children) {
	    		String encodedChild = URLEncoder.encode(child, ENCODING);
	    		nodes.put(child, String.format(CHILD_PATH, encodedNode, encodedChild));
	    	}
	    	
	        return new NodeView(connected, encodedNode, nodes);
    	} catch (InterruptedException e) {
    		LOG.error(e.getMessage(), e);
    	} catch (KeeperException e) {
    		LOG.error(e.getMessage(), e);
		} catch (UnsupportedEncodingException e) {
			LOG.error(e.getMessage(), e);
		}
		return new NodeView(false, node, nodes);
    }
}
