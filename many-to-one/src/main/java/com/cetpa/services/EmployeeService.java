package com.cetpa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetpa.entities.Department;
import com.cetpa.entities.Employee;
import com.cetpa.repositories.EmployeeRepo;

@Service
public class EmployeeService 
{
	@Autowired private EmployeeRepo employeeRepo;

	public void saveEmployee(Employee employee) 
	{
		employeeRepo.save(employee);
	}

	public Department getDepartmentByEid(int eid) 
	{
		Employee employee=employeeRepo.findById(eid).orElse(null);
		return employee.getDepartment();
	}

	public List<Employee> getListByDeptId(int did) 
	{
		return employeeRepo.getEmployeeListByDid(did);
	}
}
