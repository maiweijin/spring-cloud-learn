package com.bonade.cloud.client.inter;

import org.springframework.stereotype.Component;

@Component
public class ServiceConsumerHystrix implements ServiceConsumer {

	@Override
	public Integer max(Integer a, Integer b) {
		return -1;
	}

	@Override
	public Integer add(Integer a, Integer b) {
		return -2;
	}

}
