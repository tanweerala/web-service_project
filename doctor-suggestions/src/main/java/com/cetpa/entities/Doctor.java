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
public class Doctor 
{
	@Id
	@GeneratedValue(generator = "doc_seq")
	@SequenceGenerator(name = "doc_seq",initialValue = 111,allocationSize = 1)
	private int docid;
	@NotNull(message = "Name is required")
	@Size(min = 3,message = "Name must have atleast three characters")
	private String name;
	@NotNull(message = "City is required")
	@Pattern(regexp = "Noida|Delhi|Faridabad",message = "City can be either Noida or Delhi or Faridabad")
	private String city;
	@NotNull(message = "Email is required")
	@Email(message = "Email is invalid")
	private String email;
	@NotNull(message = "Phone number is required")
	@Size(min = 10,message = "Phone number must have atleast ten digits")
	private String phone;
	@NotNull(message = "Speciality is required")
	@Pattern(regexp = "Orthopedic|Gynecology|Dermatology|ENT",message = "Speciality can be either Orthopedic or Gynecology or Dermatology or ENT")
	private String speciality;
	public int getDocid() {
		return docid;
	}
	public void setDocid(int docid) {
		this.docid = docid;
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
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	
}
