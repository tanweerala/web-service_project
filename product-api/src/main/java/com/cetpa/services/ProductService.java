package com.cetpa.services;

import java.util.List;

import com.cetpa.entities.Product;

public interface ProductService 
{
	void saveProduct(Product product);
	List<Product> getList();
	List<Product> getListByName(String name);
	List<Product> getListByBrand(String brand);
	Product getProduct(int id);
	void deleteProduct(int id);
	void deleteByName(String name);
	void updateProduct(Product uproduct);
}
