package com.cetpa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetpa.entities.Department;
import com.cetpa.repositories.DepartmentRepo;

@Service
public class DepartmentService 
{
	@Autowired private DepartmentRepo departmentRepo;

	public void saveDepartment(Department department) 
	{
		departmentRepo.save(department);
	}
}
