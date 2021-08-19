package com.microservices.user.user_service.actuatorcustomendpoint;

import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class UserAppInfo {

	Map<String, Object> healthDetails = new LinkedHashMap<String, Object>();

	public Map<String, Object> getHealthDetails() {
		return healthDetails;
	}

	public void setHealthDetails(Map<String, Object> healthDetails) {
		this.healthDetails = healthDetails;
	}
}
