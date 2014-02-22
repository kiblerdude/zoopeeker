package org.kiblerdude.zoopeeker.resource;

import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.apache.zookeeper.ZooKeeper;

@Path("/{path:.*}")
@Produces(MediaType.TEXT_HTML)
public class NodeResource {

	private static final Logger LOG = Logger.getLogger(NodeResource.class);
	private static final String NODE_PATH = "/%s";
	private static final String CHILD_PATH = "/%s/%s";
	private static final String NO_DATA = "No data";
	private static final String ENCODING = "UTF-8";
	private final ZooKeeper zk;

	public NodeResource(ZooKeeper zk) {
		this.zk = zk;
	}

	@GET
	public NodeView getNode(@PathParam("path") String path) {
		Boolean connected = false;
		String data = NO_DATA;
		Map<String, String> nodes = new LinkedHashMap<>();
		Map<String, String> breadcrumbs = getBreadcrumbs(path);
		
		try {
			String nodePath = String.format(NODE_PATH, path);
			connected = zk.getState().isConnected();
			List<String> children = zk.getChildren(nodePath, false);

			byte[] bytes = zk.getData(nodePath, false, null);
			
			if (bytes != null) {
				data = new String(bytes, ENCODING);
			}
			
			for (String child : children) {
				String childPath = (path.isEmpty() ? String.format(NODE_PATH, child) : String.format(CHILD_PATH, path, child));
				nodes.put(child, childPath);
				System.out.println(childPath);
			}
		} catch (Throwable t) {
			LOG.error(t.getMessage(), t);
		}

		return new NodeView(connected, nodes, breadcrumbs, data);
	}
	
	private Map<String, String> getBreadcrumbs(String path) {
		Map<String, String> breadcrumbs = new LinkedHashMap<>();
		String[] nodes = path.split("/");
		
		for (int i = 0; i < nodes.length; i++) {
			StringBuilder nodePath = new StringBuilder();			
			for (int j = 0; j <= i; j++) {
				nodePath.append("/").append(nodes[j]);
			}			
			breadcrumbs.put(nodes[i], nodePath.toString());
		}
		
		return breadcrumbs;
	}
}
