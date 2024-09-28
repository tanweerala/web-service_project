package com.cetpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cetpa.entities.Department;

public interface DepartmentRepo extends JpaRepository<Department,Integer> 
{
}
