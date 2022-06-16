package com.shweta.rest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.shweta.rest.Interceptor.MyHandlerInterceptor;

/**
 * Configuration class for adding config for MyHandlerInterceptor 
 *
 */

@Configuration
public class MyConfigClass implements WebMvcConfigurer{

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new MyHandlerInterceptor()).addPathPatterns("/getEmployees");
	}
	
	

}
