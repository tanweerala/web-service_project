package com.cetpa.entities;

import org.hibernate.annotations.Parent;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Patient 
{
	@Id
	@GeneratedValue(generator = "pat_seq")
	@SequenceGenerator(name = "pat_seq",initialValue = 11111,allocationSize = 1)
	private int patid;
	@NotNull(message = "Name is required")
	@Size(min = 3,message = "Name must have atleast three characters")
	private String name;
	@NotNull(message = "City is required")
	@Size(max = 20,message = "City lenght must be 20 or bellow 20")
	private String city;
	@NotNull(message = "Email is required")
	@Email(message = "Email is invalid")
	private String email;
	@NotNull(message = "Phone number is required")
	@Size(min = 10,message = "Phone number must have atleast ten digits")
	private String phone;
	@NotNull(message = "Symptom is required")
	@Pattern(regexp = "Arthritis|Backpain|Tissue injuries|Dysmenorrhea|Skin Infection|Skin Burn|Ear Pain",message = "Symptom is invalid")
	private String symptom;
	public int getPatid() {
		return patid;
	}
	public void setPatid(int patid) {
		this.patid = patid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSymptom() {
		return symptom;
	}
	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}
		
}
