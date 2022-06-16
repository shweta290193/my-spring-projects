package com.shweta.rest.Dto;

import java.util.Date;
import java.util.List;

import com.shweta.rest.entity.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This class is to generate custom response to be sent in Reponse instead of sending only Employee/User object in response
 * This is to be used when we want to send Employee object along with some other variables in JSON Response
 *
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyCustomResponse {

	String projectAuthor;
	Date dateOfCreation;
	String projectName;
	int totalEmployees;
	List<Employee> employees;		
	
}
