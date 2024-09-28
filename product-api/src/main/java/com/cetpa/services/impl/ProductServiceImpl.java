package com.cetpa.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.stereotype.Service;

import com.cetpa.entities.Product;
import com.cetpa.repositories.ProductRepository;
import com.cetpa.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService 
{
	@Autowired private ProductRepository productRepository;

	public void saveProduct(Product product) 
	{
		productRepository.save(product);
	}
	public List<Product> getList() 
	{
		return productRepository.findAll();
	}
	public List<Product> getListByName(String name) 
	{
		return productRepository.findByName(name);
	}
	public List<Product> getListByBrand(String brand) 
	{
		return productRepository.findByBrand(brand);
	}
	public Product getProduct(int id) 
	{
		return productRepository.findById(id).orElse(null);
	}
	public void deleteProduct(int id) 
	{
		productRepository.deleteById(id);
	}
	public void deleteByName(String name) 
	{
		productRepository.deleteByName(name);
	}
	public void updateProduct(Product uproduct) 
	{
		productRepository.save(uproduct);
	}
}
