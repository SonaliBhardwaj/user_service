package com.microservices.user.user_service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoggingController {
	
	Logger logger = LoggerFactory.getLogger("LoggingController");
	
	@GetMapping("/logs")
	public String logs() {
		logger.trace("A TRACE Logger");
		logger.debug("A DEBUG Logger");
		logger.info("A INFO Logger");
		logger.warn("A WARN Logger");
		logger.error("A ERROR Logger");
		return "Differnt Levels of Logs";
		
	}
}
