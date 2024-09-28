package com.cetpa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import com.cetpa.entities.Product;

import jakarta.transaction.Transactional;

public interface ProductRepository extends JpaRepository<Product,Integer> 
{
	List<Product> findByName(String name);
	List<Product> findByBrand(String br);
	@Transactional
	@Modifying
	void deleteByName(String name);
}
