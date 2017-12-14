package com.bonade.cloud.oauthdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.oauth2.config.annotation.builders.ClientDetailsServiceBuilder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@SpringBootApplication
@EnableDiscoveryClient
@EnableAuthorizationServer
public class OauthDemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(OauthDemoApplication.class, args);
	}
}
