package com.bonade.cloud.service;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class CloudService implements TestService {

	@Override
	public Integer add(Integer a, Integer b) {
		return a + b;
	}

	@Override
	public Integer max(Integer a, Integer b) {
		return a > b ? a : b;
	}

	public String test(LombokDemo demo){
		return demo.toString();
	}
}
