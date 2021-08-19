package com.microservices.user.user_service.actuatorcustomendpoint;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "userAppInfo")
public class UserAppInfoEndPoint {
	
	//@ReadOperation - for GET operation
	//@WriteOperation - for POST operation
	//@DeleteOperation - for DELETE operation
	
	
	@ReadOperation
	public UserAppInfo userAppInfo() {
		Map<String, Object> details = new LinkedHashMap<String, Object>();
		details.put("App Location", "MAR !!");
		details.put("Status", "Reporting from MARS !!");
		
		UserAppInfo health = new UserAppInfo();
		health.setHealthDetails(details);
		
		return health;
	}
	
	@ReadOperation
	public String userAppEndPointByName(@Selector String name) {
		return "This is User Service --> " +name ;
	}

	@WriteOperation
	public void writeOperation(@Selector String name) {
		
	}
	
	@DeleteOperation
	public void DeleteOperation(@Selector String name) {
		
	}
}
