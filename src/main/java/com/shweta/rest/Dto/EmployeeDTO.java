package com.shweta.rest.Dto;

import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.shweta.rest.entity.Address;
import com.shweta.rest.entity.Department;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDTO {

	int empId;
	String name;
	long salary;
	Department department;
	List<Address> address;
}
