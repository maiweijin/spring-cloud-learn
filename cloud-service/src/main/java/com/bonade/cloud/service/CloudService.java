package com.bonade.cloud.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CloudService implements TestService {
	private static final Logger log = LoggerFactory.getLogger(CloudService.class);

	@Override
	public Integer add(Integer a, Integer b) {
		return a + b;
	}

	@Override
	public Integer max(Integer a, Integer b) {
		return a > b ? a : b;
	}
}
