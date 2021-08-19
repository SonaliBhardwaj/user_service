package com.microservices.user.user_service.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EnvDetails {

	@Value("${app.server.name}")
	private String appServerName;
	@Value("${app.server.detail}")
	private String appServerDetail;
	@Value("${spring.datasource.url}")
	private String dbURL;
	@Value("${spring.datasource.username}")
	private String dbUser;
	@Value("${spring.datasource.password}")
	private String dbPassword;
	
	public String getAppServerName() {
		return appServerName;
	}
	public void setAppServerName(String appServerName) {
		this.appServerName = appServerName;
	}
	public String getAppServerDetail() {
		return appServerDetail;
	}
	public void setAppServerDetail(String appServerDetail) {
		this.appServerDetail = appServerDetail;
	}
	public String getDbURL() {
		return dbURL;
	}
	public void setDbURL(String dbURL) {
		this.dbURL = dbURL;
	}
	public String getDbUser() {
		return dbUser;
	}
	public void setDbUser(String dbUser) {
		this.dbUser = dbUser;
	}
	public String getDbPassword() {
		return dbPassword;
	}
	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}

	@Override
	public String toString() {
		return "EnvDetails [appServerName=" + appServerName + ", appServerDetail=" + appServerDetail + ", dbURL="
				+ dbURL + ", dbUser=" + dbUser + ", dbPassword=" + dbPassword + "]";
	}

}
