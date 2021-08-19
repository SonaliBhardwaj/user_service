package com.microservices.user.user_service;

import java.time.Duration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.client.RootUriTemplateHandler;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplateHandler;

import com.microservices.user.user_service.config.MyRequestInterceptor;

//@SpringBootApplication is a combination of 
//@SpringBootConfiguration + 
//@EnableAutoConfiguration (automatically configures the beans, if you want to exclude any bean then use <exclude? tag)
//@ComponentScan

@SpringBootApplication
@EnableEurekaClient
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

	//	@Bean
	//	@LoadBalanced
	//	public RestTemplate restTemplate() {
	//		return new RestTemplate();
	//	}

	//Other way to get RestTemplate
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(RestTemplateBuilder  builder) {
		//this below UriTemplateHandler is used to prefix relative URLs
		UriTemplateHandler uriTemplateHandler = new RootUriTemplateHandler("http://localhost:8443/");
		return builder
				.uriTemplateHandler(uriTemplateHandler)
				.interceptors(myRequestInterceptor())
				//We can also set the timeout (if other service is taking time to respond, so we need to set timeout)
				.setReadTimeout(Duration.ofMillis(2000))
				.build();
	}


	//Custom Interceptor which will intercept every Request and Response
	@Bean
	public MyRequestInterceptor myRequestInterceptor() {
		return new MyRequestInterceptor();
	}

	



}
