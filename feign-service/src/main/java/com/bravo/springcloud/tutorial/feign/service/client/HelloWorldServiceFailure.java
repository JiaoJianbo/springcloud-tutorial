package com.bravo.springcloud.tutorial.feign.service.client;

import org.springframework.stereotype.Component;

@Component
public class HelloWorldServiceFailure implements HelloWorldService {

	@Override
	public String sayHello() {
		return "Hi Feign, hello world service is not available!";
	}

}
