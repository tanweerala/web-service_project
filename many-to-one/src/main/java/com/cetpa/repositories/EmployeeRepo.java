package com.cetpa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cetpa.entities.Employee;

public interface EmployeeRepo extends JpaRepository<Employee,Integer> 
{
	@Query("from Employee e where e.department.did=:arg")
	List<Employee> getEmployeeListByDid(@Param("arg") int did);
}
