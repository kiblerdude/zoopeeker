package org.kiblerdude.zoopeeker.resource;

import java.util.Map;

import com.yammer.dropwizard.views.View;

public class NodeView extends View {
	
	private final Boolean connected;
	private final String node;
	private final Map<String, String> nodes;

	public NodeView(Boolean connected, String node, Map<String, String> nodes) {
		super("node.ftl");
		this.connected = connected;
		this.node = node;
		this.nodes = nodes;
	}
	
	public Boolean getConnected() {
		return connected;
	}
	
	public String getNode() {
		return node;
	}
	
	public Map<String, String> getNodes() {
		return nodes;
	}
}
