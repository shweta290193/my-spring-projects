package com.shweta.rest.Controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shweta.rest.Dto.MyCustomResponse;
import com.shweta.rest.entity.Address;
import com.shweta.rest.entity.Employee;
import com.shweta.rest.exceptions.MyCustomException;
import com.shweta.rest.service.AddressServiceImpl;
import com.shweta.rest.service.EmployeeServiceImpl;

@RestController
public class MyRestController {
	
	@Autowired
	EmployeeServiceImpl empService;
	
	@Autowired
	AddressServiceImpl addrService;
	
	/**
	 * Test Url 
	 */	
	@GetMapping("/")
	public ResponseEntity<String> beginApp(){
		return new ResponseEntity<String>("welcome to 1st Spring Boot", HttpStatus.OK);
	}
	
	
	/**
	 * 
	 * For saveEmployee, we need to set all the Employee variables including Address, and for saveEmployee to work, Address that has to be 
	 * associated with this new Employee obj ,has to be already created and then this created address we can use to create our new Employee
	 * otherwise exception will be thrown that the address doesnt exist.
	 */
	@PostMapping("/saveEmployee")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee emp){
		Employee e = empService.createEmployee(emp);
		return new ResponseEntity<Employee>(e, HttpStatus.CREATED);
	}
	
	@PostMapping("/saveAddress")
	public ResponseEntity<Address> saveAddress(@RequestBody Address adr){
		Address a = addrService.createAddress(adr);
		return new ResponseEntity<Address>(a, HttpStatus.CREATED);
	}
	
	@GetMapping("/getEmployees")
	public ResponseEntity<List<Employee>> getEmployees(){
		return new ResponseEntity<List<Employee>>(empService.getallEmployees(), HttpStatus.OK);
	}
	
	@PutMapping("/updateEmployee/{id}")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp, @PathVariable("id") int id){
		return new ResponseEntity<Employee>(empService.updateEmployee(emp, id), HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteEmployee/{id}")
	public void deleteEmployee(@PathVariable("id") int id){
		empService.deleteEmployee(id);
		
	}
	
	/**if the id provided by user doent exist , we dont need to take of it explicitly , internally in such cases , NoSuchElementException is thrown , 
	and we have created an exception handler method for NoSuchElementException in GlobalException handler class. So whenever this particular exception will occur, 
	it will be handled by the msg and status provided by our cstom exception handler for this in GlobalException handler class
	*/
	@GetMapping("/getEmployee/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int id){
		return new ResponseEntity<Employee>(empService.getEmployeebyId(id), HttpStatus.FOUND);
	}
	
	/**
	 To get Employee by address id
	 * @throws MyCustomException 
	 */
	@GetMapping("/getEmployeeByAddressId/{id}")
	public ResponseEntity<Employee> getEmployeebyAddressId(@PathVariable("id") int id) throws MyCustomException{
		return new ResponseEntity<Employee>(empService.getEmployeebyAddressId(id), HttpStatus.FOUND);
	}
	
	@GetMapping("/getAppDetails")
	//public MyCustomResponse getAppDetails(){
	public ResponseEntity<MyCustomResponse> getAppDetails(){
		Date dateOfCreation = new Date(2022, 03, 05);
		List<Employee> empList = empService.getallEmployees();
		MyCustomResponse customResponse = new MyCustomResponse("Shweta Priyadarshani",dateOfCreation,"My Spring Boot Rest Project",empList.size(),empList);
		return new ResponseEntity<MyCustomResponse>(customResponse, HttpStatus.ACCEPTED);
	}
	
	/**
	 * Method for Pagination data
	 */
	@GetMapping("/getEmployees/{pageNo}/{pageSize}")
	public ResponseEntity<List<Employee>> getPaginatedData(@PathVariable("pageNo") int pageNo,@PathVariable("pageSize") int pageSize){
		return new ResponseEntity<List<Employee>>(empService.getEmployeesByPagination(pageNo,pageSize), HttpStatus.OK);
	}
	
	/**
	 * Method for Pagination & Sorted data
	 */
	@GetMapping("/getEmployees/{pageNo}/{pageSize}/{sortField}")
	public ResponseEntity<List<Employee>> getPaginatedSortedData(@PathVariable("pageNo") int pageNo,@PathVariable("pageSize") int pageSize
			, @PathVariable("sortField") String sortField){
		return new ResponseEntity<List<Employee>>(empService.getEmployeesByPagination_Sorting(pageNo,pageSize,sortField), HttpStatus.OK);
	}
	
	/**
	 * Method for custom query with Pagination 
	 */
	@GetMapping("/getEmployees/{pageNo}/{field}")   //field is dept id here - find highest salary in a given dept , dept id to be sent by user - show paginated data , page no selected by user
	public ResponseEntity<List<Employee>> getCustomQueryPaginatedData(@PathVariable("pageNo") int pageNo,@PathVariable("field") String field){
		return new ResponseEntity<List<Employee>>(empService.getHighestSalaryWithPagination(pageNo,field), HttpStatus.OK);
	}
	
	/**
	 * 
	 * Method for custom query to get employee with salary greater than value passed by user 
	 */
	@GetMapping("/getEmployees/{salary}")   
	public ResponseEntity<List<Employee>> getSalaryGreaterThan(@PathVariable("salary") Long salary){
		return new ResponseEntity<List<Employee>>(empService.getSalaryGreaterThan(salary), HttpStatus.OK);
	}
	
	/**
	 * 
	 * Method for custom query to get employee having pincode value passed by user 
	 */
	@GetMapping("/getEmployeesByPincode/{pin}")   
	public ResponseEntity<List<Employee>> getEmployeesByPincode(@PathVariable("pin") Long pin){
		return new ResponseEntity<List<Employee>>(empService.getEmployeesByPincode(pin), HttpStatus.OK);
	}
	
}
