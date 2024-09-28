package com.cetpa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cetpa.entities.Product;
import com.cetpa.services.ProductService;

@RestController
@RequestMapping("product")
public class ProductController 
{
	@Autowired private ProductService productService;
	
	//http://localhost:8080/product/add
	@PostMapping("add")
	public ResponseEntity<Product> addProduct(@RequestBody Product product)
	{
		productService.saveProduct(product);
		return ResponseEntity.status(HttpStatus.CREATED).body(product);
	}
	//http://localhost:8080/product/list
	@GetMapping("list")
	public ResponseEntity<List<Product>> getProductList()
	{
		List<Product> productList=productService.getList();
		return ResponseEntity.status(HttpStatus.OK).body(productList);
	}
	//http://localhost:8080/product/list/byname?name=Laptop
	@GetMapping("list/byname")
	public ResponseEntity<List<Product>> getProductListByName(@RequestParam("na") String name)
	{
		List<Product> productList=productService.getListByName(name);
		if(productList.isEmpty())
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();	
		}
		return ResponseEntity.status(HttpStatus.OK).body(productList);
	}
	//http://localhost:8080/product/list/bybrand/Logitech
	@GetMapping("list/bybrand/{brand}")
	public ResponseEntity<List<Product>> getProductListByBrand(@PathVariable ("brand") String brand)
	{
		List<Product> productList=productService.getListByBrand(brand);
		if(productList.isEmpty())
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();	
		}
		return ResponseEntity.status(HttpStatus.OK).body(productList);
	}
	//http://localhost:8080/product/details?pid=104
	@GetMapping("details")
	public ResponseEntity<Product> getProduct(@RequestParam("pid") int id)
	{
		Product product=productService.getProduct(id);
		if(product==null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();	
		return ResponseEntity.status(HttpStatus.OK).body(product);
	}
	@DeleteMapping("delete")
	public ResponseEntity<Product> deleteProduct(@RequestParam("pid") int id)
	{
		Product product=productService.getProduct(id);
		if(product==null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		productService.deleteProduct(id);
		return ResponseEntity.status(HttpStatus.OK).body(product);
	}
	@DeleteMapping("delete/byname")
	public ResponseEntity<List<Product>> deleteProductListByName(@RequestParam("na") String name)
	{
		List<Product> productList=productService.getListByName(name);
		if(productList.isEmpty())
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();	
		}
		productService.deleteByName(name);
		return ResponseEntity.status(HttpStatus.OK).body(productList);
	}
	@PutMapping("update/{pid}")
	public ResponseEntity<Product> updateProduct(@PathVariable("pid") int id,@RequestBody Product uproduct)
	{
		Product dproduct=productService.getProduct(id);
		if(dproduct!=null)
		{
			uproduct.setPid(id);
			productService.updateProduct(uproduct);
			return ResponseEntity.ok(uproduct);	
		}
		productService.saveProduct(uproduct);
		return ResponseEntity.status(HttpStatus.CREATED).body(uproduct);
	}
	@PatchMapping("pupdate")
	public ResponseEntity<Product> pupdateProduct(@RequestParam("pid") int id,@RequestBody Product uproduct)
	{
		Product dproduct=productService.getProduct(id);
		if(dproduct==null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();	
		}
		String name=uproduct.getName();
		String brand=uproduct.getBrand();
		int price=uproduct.getPrice();
		if(name!=null)
			dproduct.setName(name);
		if(brand!=null)
			dproduct.setBrand(brand);
		if(price!=0)
			dproduct.setPrice(price);
		productService.updateProduct(dproduct);
		return ResponseEntity.ok(dproduct);
	}
}
