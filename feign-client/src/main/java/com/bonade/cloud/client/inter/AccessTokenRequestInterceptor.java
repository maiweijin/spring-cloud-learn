package com.bonade.cloud.client.inter;

import org.springframework.stereotype.Component;

import feign.RequestInterceptor;
import feign.RequestTemplate;

@Component
public class AccessTokenRequestInterceptor implements RequestInterceptor {

	@Override
	public void apply(RequestTemplate template) {
		template.header("access_token", "qdwaswa");
	}

}
