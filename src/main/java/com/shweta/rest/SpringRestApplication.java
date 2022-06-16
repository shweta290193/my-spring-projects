package com.shweta.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.shweta.rest.entity.Address;
import com.shweta.rest.entity.Department;
import com.shweta.rest.entity.Employee;
import com.shweta.rest.repository.AddressRepository;
import com.shweta.rest.repository.EmployeeRepository;

@SpringBootApplication
@EnableJpaRepositories
public class SpringRestApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(SpringRestApplication.class, args);
		
		//ApplicationContext context = SpringApplication.run(SpringRestApplication.class, args);
		/*EmployeeRepository empdrepo = context.getBean(EmployeeRepository.class);
		AddressRepository adrepo = context.getBean(AddressRepository.class);
		
			Department dept = new Department(101, "kv");
			Address address1 = new Address(0, "Kribhco", 394515);
			adrepo.save(address1);
			Address address2 = new Address(0, "Gurgaon", 211008);
			adrepo.save(address2);
			
			List<Address > addrLi= new ArrayList<Address>();
			addrLi.add(address1);
			addrLi.add(address2);
			
		  Employee emp = new Employee(0, "shweta", 4000, dept,addrLi);
		  System.out.println("**********"+emp); 
		 
		  empdrepo.save(emp);*/
		  
		 
	}

}
