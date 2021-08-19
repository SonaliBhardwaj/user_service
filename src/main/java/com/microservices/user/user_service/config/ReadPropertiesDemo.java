package com.microservices.user.user_service.config;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReadPropertiesDemo {

	//Below is the way we read/associate properties from application.properties/yml
	//if the property is not present in properties file then it will give the DefaultUser as value
	@Value("${user.fb.name:DefaultUser}")
	private String fbName;

	//For map # is necessary
	@Value("#{${values.map}}")
	private Map<String, Integer> mapValue;

	@Value("${list}")
	private List<String> arrayVal;
	
	@Value("#{'${list}'.split(',')}")
	private List<String> listOfItems;

	public String getFbName() {
		return fbName;
	}

	public void setFbName(String fbName) {
		this.fbName = fbName;
	}

	public Map<String, Integer> getMapValue() {
		return mapValue;
	}

	public void setMapValue(Map<String, Integer> mapValue) {
		this.mapValue = mapValue;
	}

	public List<String> getArrayVal() {
		return arrayVal;
	}

	public void setArrayVal(List<String> arrayVal) {
		this.arrayVal = arrayVal;
	}

	public List<String> getListOfItems() {
		return listOfItems;
	}

	public void setListOfItems(List<String> listOfItems) {
		this.listOfItems = listOfItems;
	}

	@Override
	public String toString() {
		return "ReadPropertiesDemo [fbName=" + fbName + ", mapValue=" + mapValue + ", arrayVal=" + arrayVal
				+ ", listOfItems=" + listOfItems + "]";
	}
	
	
}
