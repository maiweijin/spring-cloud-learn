package com.bonade.cloud.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bonade.cloud.client.inter.ServiceConsumer;

@RestController
@EnableFeignClients
@SpringCloudApplication
public class FeignClientApplication {
	@Autowired
	ServiceConsumer service;

	public static void main(String[] args) {
		SpringApplication.run(FeignClientApplication.class, args);
	}

	@GetMapping("/")
	public String test() {
		Integer add = service.add(1, 2);
		Integer max = service.max(3, 4);
		return add + "" + max;
	}
}
