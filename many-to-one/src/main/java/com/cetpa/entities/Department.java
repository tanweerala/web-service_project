package com.cetpa.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Department 
{
	@Id
	@GeneratedValue(generator = "dept_seq")
	@SequenceGenerator(name = "dept_seq",initialValue = 101,allocationSize = 1)
	private int did;
	private String name;
	private String dhead;
	private String phone;
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDhead() {
		return dhead;
	}
	public void setDhead(String dhead) {
		this.dhead = dhead;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
