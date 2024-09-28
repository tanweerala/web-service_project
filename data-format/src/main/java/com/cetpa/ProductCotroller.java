package com.cetpa;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@ResponseBody
@RequestMapping("product")
public class ProductCotroller 
{
	@GetMapping(value="details",produces = "application/json")
	public ResponseEntity<Product> getProduct()
	{
		Product product=new Product(101,"Mouse","Logitech",1200);
		ResponseEntity<Product> response=ResponseEntity.status(200).body(product);
		return response;
	}
}
