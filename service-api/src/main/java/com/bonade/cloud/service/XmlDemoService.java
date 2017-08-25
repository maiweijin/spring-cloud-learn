package com.bonade.cloud.service;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user")
public interface XmlDemoService {

	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE })
	void postUser(User user);

	@GetMapping(consumes = { MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE })
	User getUser();
}
