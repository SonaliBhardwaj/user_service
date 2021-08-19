package com.microservices.user.user_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.user.user_service.config.ReadPropertiesConfigDemo;
import com.microservices.user.user_service.config.ReadPropertiesDemo;

@RestController
public class ReadPropertiesController {
	
	@Autowired
	private ReadPropertiesDemo readPropertiesDemo;
	
	@Autowired
	private ReadPropertiesConfigDemo configDemo;
	
	@GetMapping("/readProperties")
	public String getReadPropertiesDemo() {
		return readPropertiesDemo.toString();
	}
	
	@GetMapping("/readConfigProperties")
	public String getReadPropertiesConfigDemo() {
		return configDemo.toString();
	}

}
