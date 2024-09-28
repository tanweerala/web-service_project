package com.cetpa.services;

import java.util.List;

import com.cetpa.entities.Doctor;
import com.cetpa.entities.Patient;

public interface PatientService 
{
	void savePatient(Patient patient);
	List<Doctor> getDoctorListByPatId(int pid);
}
