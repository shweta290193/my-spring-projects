package com.shweta.rest.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "TB_employee")
//@NamedNativeQuery(name = "getByAddrId", query = "select * from tb_employee where emp_id = (select e_id from tb_address where addr_id=?1 )")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int empId;
	String name;
	long salary;
	
	@Embedded
	Department department;
	
	@OneToMany
	@JoinColumn(name = "eId", referencedColumnName = "empId")
	List<Address> address;
	
	
}
