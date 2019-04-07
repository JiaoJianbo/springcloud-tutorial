package com.bravo.springcloud.tutorial.zuul.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy //其实这个注解已经包含了 @EnableCircuitBreaker 和 @EnableDiscoveryClient
@EnableEurekaClient
public class ZuulServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(ZuulServiceApplication.class, args);
	}
}
