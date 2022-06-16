package com.shweta.rest.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shweta.rest.entity.Employee;
import com.shweta.rest.exceptions.MyCustomException;
import com.shweta.rest.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	/*
	 * @Autowired ModelMapper modelMapper;
	 */
	
	@Override
	public Employee createEmployee(Employee emp) {
		return employeeRepository.save(emp);
	}

	@Override
	public Employee updateEmployee(Employee emp,int id) {
		Employee e=  employeeRepository.findById(id).get();
		
		e.setAddress(emp.getAddress());  //sets a list of addresses
		e.setDepartment(emp.getDepartment());
		e.setName(emp.getName());
		e.setSalary(emp.getSalary());
		return employeeRepository.save(e);
	}

	@Override
	public void deleteEmployee(int id)  {
		System.out.println("************ inside deleteEmployee");
		System.out.println("***********findById: "+employeeRepository.findById(id));
		employeeRepository.deleteById(id);
		
	}

	@Override
	public List<Employee> getallEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeebyId(int id) {
		return employeeRepository.findById(id).get();
	}

	//custom method w/o custom query
	@Override
	public List<Employee> getEmployeebyName(String name) {
		 return employeeRepository.findByName(name);
	}
	
	//custom method w/o custom query
	@Override
	public Employee getEmployeebyNameAndId(String name, int id) {
		 return employeeRepository.findByNameAndEmpId(name,id);
	}

	@Override
	public List<Employee> getEmployeebyDepartmentId(int id) {
		List<Employee> empList = employeeRepository.findByDeptId(id);
		return empList;
	}

	
	  @Override 
	  public Employee getEmployeebyAddressId(int id) throws MyCustomException 
	  { 
		  //Employee emp = employeeRepository.getByAddress(id);
		  //Employee emp = employeeRepository.getByAddrIds(id);
		  Employee emp = employeeRepository.abc(id);
		  if(emp==null)
			  throw new MyCustomException();
		  return emp; 
	  }
	 

	  //Left to be implemented here and to be called in controller - to be done using PatchMapping
	@Override
	public Employee updateOnlyName(int id) {
		return null;
	}

	@Override
	public List<Employee> getEmployeesByPagination(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo, pageSize);				
		return employeeRepository.findAll(pageable).getContent();
		
	}

	@Override
	public List<Employee> getEmployeesByPagination_Sorting(int pageNo, int pageSize, String sortField) {
		Pageable pageable = PageRequest.of(pageNo, pageSize,Sort.by(Direction.DESC, sortField));				
		return employeeRepository.findAll(pageable).getContent();
	}

	//field is dept id, find highest salary in a given dept , dept id to be sent by user - show paginated data , page no selected by user
	//Assuming default page size of 3
	@Override
	public List<Employee> getHighestSalaryWithPagination(int pageNo, String field) {
		Pageable pageable = PageRequest.of(pageNo,3 ,Sort.by(Direction.DESC, "salary"));
		//return employeeRepository.aaaDeptId(pageable,field);
		return null;
	}

	@Override
	public List<Employee> getSalaryGreaterThan(Long salary) {
		return employeeRepository.findBySalaryGreaterThan(salary);
	}

	@Override
	public List<Employee> getEmployeesByPincode(Long pin) {
		return employeeRepository.findByAddressPincode(pin);
	}

	

}
