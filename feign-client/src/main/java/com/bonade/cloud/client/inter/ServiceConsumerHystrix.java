package com.bonade.cloud.client.inter;

//@Component
public class ServiceConsumerHystrix implements ServiceConsumer {

	@Override
	public Integer add(Integer a, Integer b) {
		return Integer.MIN_VALUE;
	}

	@Override
	public Integer max(Integer a, Integer b) {
		return Integer.MAX_VALUE;
	}

}
