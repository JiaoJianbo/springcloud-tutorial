package com.bravo.springcloud.tutorial.feign.service.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "SERVICE-HELLOWORLD", fallback = HelloWorldServiceFailure.class)
public interface HelloWorldService {

	@RequestMapping(value = "/") // 1.不支持 @GetMapping这样的注解。 2.@PathVariable必须显式地设置value，不能使用默认值
	String sayHello();
}
