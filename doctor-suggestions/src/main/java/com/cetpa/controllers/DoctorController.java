package com.cetpa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cetpa.entities.Doctor;
import com.cetpa.services.DoctorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("doctor")
public class DoctorController 
{
	@Autowired private DoctorService doctorService;
	
	@PostMapping("add")
	public ResponseEntity<Doctor> addDoctor(@Valid @RequestBody Doctor doctor)
	{
		doctorService.add(doctor);
		return ResponseEntity.status(HttpStatus.CREATED).body(doctor);
	}
	@GetMapping("list")
	public ResponseEntity<List<Doctor>> getList()
	{
		List<Doctor> docList=doctorService.getDoctorList();
		return ResponseEntity.ok(docList);
	}
	@GetMapping("details/{did}")
	public ResponseEntity<Doctor> getDoctorDetails(@PathVariable("did") int docid)
	{
		Doctor doctor=doctorService.getDetails(docid);
		return ResponseEntity.ok(doctor);
	}
}
