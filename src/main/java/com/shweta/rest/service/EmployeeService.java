package com.shweta.rest.service;

import java.util.List;


import com.shweta.rest.entity.Employee;
import com.shweta.rest.exceptions.MyCustomException;

public interface EmployeeService {
	
	Employee createEmployee(Employee emp);
	
	Employee updateEmployee(Employee emp,int id);
	
	Employee updateOnlyName(int id);
	
	void deleteEmployee (int id) throws MyCustomException ;
	
	List<Employee> getallEmployees();
	
	Employee getEmployeebyId(int id);
	
	List<Employee> getEmployeebyName(String name);
	
	Employee getEmployeebyNameAndId(String name,int Id);
	
	List<Employee> getEmployeebyDepartmentId(int id);
	
	Employee getEmployeebyAddressId(int id) throws MyCustomException;
	
	List<Employee> getEmployeesByPagination(int pageNo, int pageSize);
	
	List<Employee> getEmployeesByPagination_Sorting(int pageNo, int pageSize,String sortField);
	
	//for pagination with custom query
	List<Employee> getHighestSalaryWithPagination(int pageNo, String field);
	
	//to get employees with salary>80000
	List<Employee> getSalaryGreaterThan(Long salary);
	
	//to get employee having pincode value passed by user 
	List<Employee> getEmployeesByPincode(Long pin);
	
}
