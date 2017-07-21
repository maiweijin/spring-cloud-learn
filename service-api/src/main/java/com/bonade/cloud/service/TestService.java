package com.bonade.cloud.service;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface TestService {
	@PostMapping(value = "/add", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
	Integer add(@RequestParam("a") Integer a, @RequestParam("b") Integer b);

	@PostMapping(value = "/max", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
	Integer max(@RequestParam("a") Integer a, @RequestParam("b") Integer b);
}
