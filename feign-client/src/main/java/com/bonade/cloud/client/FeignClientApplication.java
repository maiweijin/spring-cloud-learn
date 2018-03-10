package com.bonade.cloud.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.bind.annotation.*;

import com.bonade.cloud.service.TestService;

import java.security.Principal;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@RestController
@EnableFeignClients
@SpringCloudApplication
@EnableHystrix
@EnableOAuth2Sso
public class FeignClientApplication {
	@Autowired
	TestService service;
	@Value("security.oauth2.client.client-id")
	String clientId;
	@Value("security.oauth2.client.client-secret")
	String secret;
	List<OAuth2AccessToken> tokenList = new LinkedList<>();
	public static void main(String[] args) {
		SpringApplication.run(FeignClientApplication.class, args);
	}
	@Autowired
	AuthorizationService authorizationService;
	@GetMapping("/")
	public String test() {
		Integer add = service.add(1, 2);
		Integer max = service.max(3, 4);
		return add + "," + max;
	}
	@GetMapping("login")
	public String login(String code){
		OAuth2AccessToken oAuth2AccessToken = authorizationService.postAccessToken(code);
		return oAuth2AccessToken.getValue();
	}
	@FeignClient("http://app1:app_secret@127.0.0.1:8080")
	public static interface AuthorizationService{
		@RequestMapping(
				value = {"/oauth/token"},
				method = {RequestMethod.POST}
		)
		OAuth2AccessToken postAccessToken(@RequestParam("code") String code);
	}
}
