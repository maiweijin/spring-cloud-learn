package com.bonade.cloud.client.inter;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "http://localhost:15684/", url = "http://localhost:15684/")
public interface Demo {
	@PostMapping(value = "/test", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	String test(User body);
}
