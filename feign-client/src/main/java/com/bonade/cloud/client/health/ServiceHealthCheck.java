package com.bonade.cloud.client.health;

import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.boot.actuate.health.Health;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.bonade.cloud.client.inter.FeignClientsConfigurationExtend;

@FeignClient(value = "ADD-SERVICE", configuration = FeignClientsConfigurationExtend.class)
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
	@GetMapping(value = "health", consumes = MediaType.APPLICATION_JSON)
	Map<String, Object> health0();
}
