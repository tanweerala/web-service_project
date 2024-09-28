package com.cetpa.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetpa.entities.Doctor;
import com.cetpa.entities.Patient;
import com.cetpa.exceptions.PatientNotFoundException;
import com.cetpa.repositories.DoctorRepository;
import com.cetpa.repositories.PatientRepository;
import com.cetpa.services.PatientService;
import com.cetpa.utility.SpecialityFinder;

@Service
public class PatientServiceImpl implements PatientService 
{
	@Autowired private PatientRepository patientRepository;
	@Autowired private DoctorRepository doctorRepository;

	public void savePatient(Patient patient) 
	{
		patientRepository.save(patient); 
	}
	public List<Doctor> getDoctorListByPatId(int pid) 
	{
		Patient patient=patientRepository.findById(pid).orElseThrow(()->new PatientNotFoundException("Patient with id "+pid+" not found"));
		String city=patient.getCity();
		if(!(city.equals("Noida") || city.equals("Delhi") || city.equals("Faridabad")))
		{
			throw new RuntimeException("We are still waiting to expand to your location"); 
		}
		String symptom=patient.getSymptom();
		String speciality=SpecialityFinder.map.get(symptom);
		List<Doctor> docList=doctorRepository.getDoctorListBySpeciality(city,speciality);
		if(docList.isEmpty())
		{
			throw new RuntimeException("There isn’t any doctor present at your location for your symptom");
		}
		return docList;
	}
	
}
