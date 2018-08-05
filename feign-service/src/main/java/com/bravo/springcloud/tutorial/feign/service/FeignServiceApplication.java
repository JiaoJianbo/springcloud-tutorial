package com.bravo.springcloud.tutorial.feign.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableDiscoveryClient //开启服务自动发现
@EnableFeignClients //开启Feign的功能

// Feign服务由于内置断路器支持， 所以在使用断路器时没有@EnableCircuitBreaker注解，
// 但要使用 hystrix dashboard 则必须加，否则会报“Unable to connect to Command Metric Stream”错误
@EnableCircuitBreaker
@EnableHystrixDashboard //加入hystrix dashboard
public class FeignServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeignServiceApplication.class, args);
	}

}
