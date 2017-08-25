package com.bonade.cloud.client.health;

import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.boot.actuate.health.Health;

public interface ServiceHealthCheck {

	default Health health() {
		try {
			String status = health0().get("status").toString();
			return Health.status(status).build();
		} catch (Exception e) {
			return Health.down().build();
		}
	}

	@GET
	@Path("health")
	@Produces(MediaType.APPLICATION_JSON)
	Map<String, Object> health0();
}
