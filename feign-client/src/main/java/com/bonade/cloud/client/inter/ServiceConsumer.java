package com.bonade.cloud.client.inter;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.feign.FeignClientsConfiguration;

import com.bonade.cloud.service.TestService;

@FeignClient(value = "add-service", fallback = ServiceConsumerHystrix.class, configuration = FeignClientsConfiguration.class)
public interface ServiceConsumer extends TestService {
}
