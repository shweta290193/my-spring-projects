package com.shweta.rest.actuators;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "my-Endpoint")
public class MyCustomEndpoints {
	
	Map<String, String> customEpMap = new HashMap<>();
	
	@PostConstruct
	public void initMyMap()
	{
		customEpMap.put("Author-name", "Shweta");
		customEpMap.put("project-name", "springRest");
		customEpMap.put("creation-date", "05 march 2022");
	}

	//Endpoint for this method - http://localhost:8080/actuator/my-Endpoint
	@ReadOperation
	public Map<String, String> getMyMap()
	{
		return customEpMap;
	}
	
	//Endpoint for this method - http://localhost:8080/actuator/my-Endpoint/Author-name - Author-name can be replaced by any key of customEpMap
	@ReadOperation
	public String getMyMapByKey(@Selector String key)
	{
		return customEpMap.get(key);
	}
}
