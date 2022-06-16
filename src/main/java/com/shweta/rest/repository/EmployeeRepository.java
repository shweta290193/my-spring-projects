package com.shweta.rest.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shweta.rest.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	List<Employee> findByName(String name);
	
	Employee findByNameAndEmpId(String name, int id);
	
	List<Employee> findBySalaryGreaterThan(Long salary);	//this name works automatically as inbuilt jpa method
	
	List<Employee> findByAddressPincode(Long pin);	//this name works automatically as inbuilt jpa method,so we could avoid methods- findByDeptId and abc this way

	//JPQL Query
	@Query("select s from Employee s where s.department.deptId =?1 ")
	List<Employee> findByDeptId(int id);

	
	/**
	 * Below , getByAddress - if you give any name apart from getByAddress or findByAddress,suppose getEmpByAddress, it will say getEmpByAddress 
	 * memeber var not found in Employee class - need to look into this
	 * @param id
	 * @return
	 */
	  //Native Query
	 @Query(
	  value="select * from tb_employee where emp_id = (select e_id from tb_address where addr_id=?1 )", nativeQuery = true) 
	 Employee abc(int id);
	  
		
		
		/*
		 * //Native custom Query
		 * 
		 * @Query(
		 * name="select * from tb_employee where emp_id = (select e_id from tb_address where addr_id=?1 "
		 * , nativeQuery = true) List<Employee> aaaDeptId(Pageable p,String id);
		 */
		 
		 
	 

}
