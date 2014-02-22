package org.kiblerdude.zoopeeker.resource;

import java.util.Map;

import com.yammer.dropwizard.views.View;

public class NodeView extends View {
	
	private final Boolean connected;
	private final String data;
	private final Map<String, String> nodes;
	private final Map<String, String> breadcrumbs;

	public NodeView(Boolean connected, Map<String, String> nodes, Map<String, String> breadcrumbs, String data) {
		super("node.ftl");
		this.connected = connected;
		this.data = data;
		this.nodes = nodes;
		this.breadcrumbs = breadcrumbs;
	}
	
	public Boolean getConnected() {
		return connected;
	}
	
	public String getData() {
		return data;
	}
	
	public Map<String, String> getNodes() {
		return nodes;
	}
	
	public Map<String, String> getBreadcrumbs() {
		return breadcrumbs;
	}	
}
