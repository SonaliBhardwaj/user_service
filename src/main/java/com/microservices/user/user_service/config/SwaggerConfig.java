package com.microservices.user.user_service.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	//we can have any name for this method but need to declare as @Bean and it should return Docket
	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				//.paths(PathSelectors.ant("/user/*"))
				.apis(RequestHandlerSelectors.basePackage("com.microservices.user.user_service"))
				.build()
				.apiInfo(apiDetails());
	}
	
	//Another way of giving the below information
//	@Bean
//	public Docket api() { 
//		return new Docket(DocumentationType.SWAGGER_2)  
//				.select()                                  
//				.apis(RequestHandlerSelectors.any())              
//				.paths(PathSelectors.any())                          
//				.build();                                           
//	}
	
	private ApiInfo apiDetails() {
		return new ApiInfo("User Service API", 
							"Sample Example Spring Boot and Swagger",
							"1.0", 
							"Free to use", 
							new springfox.documentation.service.Contact("Sonali", "http://fb.com", "abc.com"),
							"API Lic", 
							"http://fb.com",
							Collections.emptyList());
	}

}
