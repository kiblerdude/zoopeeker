package org.kiblerdude.zoopeeker;

import com.yammer.metrics.core.HealthCheck;

public class ZooPeekerHealthCheck extends HealthCheck {

	public ZooPeekerHealthCheck() {
		super("zoopeeker");
	}

	@Override
	protected Result check() throws Exception {
		return Result.healthy();
	}
}