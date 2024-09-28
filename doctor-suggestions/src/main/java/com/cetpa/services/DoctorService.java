package com.cetpa.services;

import java.util.List;

import com.cetpa.entities.Doctor;

public interface DoctorService 
{
	void add(Doctor doctor);
	List<Doctor> getDoctorList();
	Doctor getDetails(int docid);
}
