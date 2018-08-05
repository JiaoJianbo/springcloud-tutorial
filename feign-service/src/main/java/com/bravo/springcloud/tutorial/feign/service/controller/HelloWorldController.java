package com.bravo.springcloud.tutorial.feign.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bravo.springcloud.tutorial.feign.service.client.HelloWorldService;


@RestController
public class HelloWorldController {
	@Autowired
	HelloWorldService helloWorldService;

	@RequestMapping(value="/hi")
	public String sayHello() {
		return helloWorldService.sayHello();
	}
}
