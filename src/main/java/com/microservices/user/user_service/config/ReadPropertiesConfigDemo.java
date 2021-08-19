package com.microservices.user.user_service.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix="config")
public class ReadPropertiesConfigDemo {

	//Here, if we dont have any property in properties file, it will initialize to default values as per Data type
	private String host;
	private String port;
	private String userName;
	private ThirdParty thirdParty;
	
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Override
	public String toString() {
		return "ReadPropertiesConfigDemo [host=" + host + ", port=" + port + ", userName=" + userName + ", thirdParty="
				+ thirdParty + "]";
	}
	public ThirdParty getThirdParty() {
		return thirdParty;
	}
	public void setThirdParty(ThirdParty thirdParty) {
		this.thirdParty = thirdParty;
	}

	//This class should be static
	private static class ThirdParty{
		private String host;
		private String port;
		private String name;
		
		public String getHost() {
			return host;
		}
		public void setHost(String host) {
			this.host = host;
		}
		public String getPort() {
			return port;
		}
		public void setPort(String port) {
			this.port = port;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		@Override
		public String toString() {
			return "ThirdParty [host=" + host + ", port=" + port + ", name=" + name + "]";
		}
	}
	
}
