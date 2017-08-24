package com.bonade.cloud.client.health;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
public class ServiceHealthIndicator implements HealthIndicator {

	@Autowired
	ServiceHealth health;

	@Override
	public Health health() {
		return health.health();
	}

}

@FeignClient(value = "ADD-SERVICE")
interface ServiceHealth {

	default Health health() {
		try {
			String status = health0().get("status").toString();
			return Health.status(status).build();
		} catch (Exception e) {
			return Health.down().build();
		}
	}

	@GetMapping(value = "health", produces = { MediaType.APPLICATION_JSON_VALUE })
	Map<String, Object> health0();
}
