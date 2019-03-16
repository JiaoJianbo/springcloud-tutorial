package com.bravo.springcloud.tutorial.ribbon.service.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HelloWorldService {
	@Autowired 
	RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "serviceNotAvailable")
	public String getHelloContent() {
		return restTemplate.getForObject("http://SERVICE-HELLOWORLD/", String.class); // 这里的 url 是 虚拟IP，并不带具体的端口号
	}
	
	public String serviceNotAvailable() {
		return "hello world service is not available!";
	}
	
	/*
	 * @HystrixCommand注解定义的fallbackMethod方法，需要特别注意的有两点：
	 * 第一， fallbackMethod的返回值和参数类型需要和被@HystrixCommand注解的方法完全一致。否则会在运行时抛出异常。
	 * 比如本例中，serviceFailure（）的返回值和getHelloContant()方法的返回值都是String。
	 * 第二， 当底层服务失败后，fallbackMethod替换的不是整个被@HystrixCommand注解的方法（本例中的getHelloContant), 
	 * 替换的只是通过restTemplate去访问的具体服务。可以从中的system输出看到， 即使失败，控制台输出里面依然会有“call SERVICE-HELLOWORLD”。
	 */
}
