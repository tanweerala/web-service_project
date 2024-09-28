package com.cetpa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cetpa.entities.Department;
import com.cetpa.services.DepartmentService;

@RestController
@RequestMapping("department")
public class DepartmentController 
{
	@Autowired private DepartmentService departmentService;
	
	@PostMapping("add")
	public ResponseEntity<Department> addDepartment(@RequestBody Department department)
	{
		departmentService.saveDepartment(department);
		return ResponseEntity.status(HttpStatus.CREATED).body(department);
	}
}
