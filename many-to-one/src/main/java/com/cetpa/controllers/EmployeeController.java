package com.cetpa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cetpa.entities.Department;
import com.cetpa.entities.Employee;
import com.cetpa.services.EmployeeService;

@RestController
@RequestMapping("employee")
public class EmployeeController 
{
	@Autowired private EmployeeService employeeService;
	
	@PostMapping("add")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee)
	{
		employeeService.saveEmployee(employee);
		return ResponseEntity.status(HttpStatus.CREATED).body(employee);
	}
	@GetMapping("department/byempid")
	public ResponseEntity<Department> getDepartmentByEmployeeId(@RequestParam("eid") int eid)
	{
		Department department=employeeService.getDepartmentByEid(eid);
		return ResponseEntity.ok(department);
	}
	@GetMapping("emplist/bydeptid")
	public ResponseEntity<List<Employee>> getEmployeeListByDepartmentId(@RequestParam("did") int did)
	{
		List<Employee> elist=employeeService.getListByDeptId(did);
		return ResponseEntity.ok(elist);
	}
}
