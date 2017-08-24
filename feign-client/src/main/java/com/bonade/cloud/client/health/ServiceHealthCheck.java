package com.bonade.cloud.client.health;

import java.util.Map;

import org.springframework.boot.actuate.health.Health;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

public interface ServiceHealthCheck {

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
