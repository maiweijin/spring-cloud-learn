package com.bonade.cloud.client.inter;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.feign.support.SpringMvcContract;

import com.bonade.cloud.service.TestService;
import org.springframework.context.annotation.Primary;

@Primary
@FeignClient(value = "add-service", fallback = ServiceConsumerHystrix.class, configuration = SpringMvcContract.class)
public interface ServiceConsumer extends TestService {
}
