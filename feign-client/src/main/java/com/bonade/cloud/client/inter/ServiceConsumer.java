package com.bonade.cloud.client.inter;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.bonade.cloud.service.TestService;

@FeignClient(value = "add-service")
public interface ServiceConsumer extends TestService {

}
