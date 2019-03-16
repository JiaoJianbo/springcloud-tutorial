package com.bravo.springcloud.tutorial.eureka.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
//@EnableDiscoveryClient // Client 通用配置
@EnableEurekaClient // Eureka client 专用配置
@RestController
public class EurekaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientApplication.class, args);
	}
	
	@Value("${server.port}")
	String port;
	
	@RequestMapping("/")
	public String home() {
		return "Hello world from client port " + port;
	}
	
	@RequestMapping("/info")
	public String info() {
		return "Hello world response from client port: " + port;
	}
}
