package com.bonade.cloud.client.health;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;

@Component
public class ServiceHealthIndicator implements HealthIndicator {

	@Autowired
	ServiceHealth health;

	@Override
	public Health health() {
		try {
			return health.health();
		} catch (Exception e) {
			return Health.down().build();
		}
	}

}

@FeignClient(value = "ADD-SERVICE")
interface ServiceHealth extends ServiceHealthCheck {

}
