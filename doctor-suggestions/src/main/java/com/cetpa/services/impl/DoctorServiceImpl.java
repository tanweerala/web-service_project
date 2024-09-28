package com.cetpa.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetpa.entities.Doctor;
import com.cetpa.exceptions.DoctorNotFoundException;
import com.cetpa.repositories.DoctorRepository;
import com.cetpa.services.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService 
{
	@Autowired private DoctorRepository doctorRepository;

	public void add(Doctor doctor) 
	{
		doctorRepository.save(doctor);
	}
	public List<Doctor> getDoctorList() 
	{
		return doctorRepository.findAll();
	}
	public Doctor getDetails(int docid) 
	{
		Doctor doctor=doctorRepository.findById(docid).orElse(null);
		if(doctor==null)
		{
			throw new DoctorNotFoundException("Doctor with id "+docid+" not found");
		}
		return doctor;
	}
}
