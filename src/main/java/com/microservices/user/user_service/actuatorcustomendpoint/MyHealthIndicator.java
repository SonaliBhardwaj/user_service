package com.microservices.user.user_service.actuatorcustomendpoint;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class MyHealthIndicator implements HealthIndicator{

	@Override
	public Health health() {
		//perform some health check 
		int errorCode = check();
		if(errorCode != 0 ) {
			return Health.down().withDetail("Error Code", errorCode).build();
		}
		return Health.up().build();
	}
	
	private int check() {
		//logic to check health. this can be DB hit or some other 
		//check depending upon our requeirement
		return 0;
	}

}
