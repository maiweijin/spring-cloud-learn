package com.bonade.cloud.client.inter;

import org.springframework.cloud.netflix.feign.FeignClientsConfiguration;
import org.springframework.core.convert.ConversionService;

import feign.Contract;
import feign.jaxrs.JAXRSContract;

public class FeignClientsConfigurationExtend extends FeignClientsConfiguration {
	@Override
	public Contract feignContract(ConversionService feignConversionService) {
		return new JAXRSContract();
	}
}
