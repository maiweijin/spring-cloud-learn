package com.bonade.cloud.client.health;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bonade.cloud.client.inter.ServiceConsumer;
import com.netflix.appinfo.HealthCheckHandler;
import com.netflix.appinfo.InstanceInfo.InstanceStatus;

@Component
public class ServiceHealthCheckHandler implements HealthCheckHandler {
	@Autowired
	ServiceConsumer service;

	@Override
	public InstanceStatus getStatus(InstanceStatus currentStatus) {
		Integer i = null;
		try {
			i = service.add(1, 1);
		} catch (Exception e) {
			return InstanceStatus.DOWN;
		}
		if (!i.equals(2)) {
			return InstanceStatus.DOWN;
		}
		return InstanceStatus.UP;
	}

}
