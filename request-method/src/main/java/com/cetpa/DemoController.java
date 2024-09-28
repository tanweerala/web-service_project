package com.cetpa;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("demo")
public class DemoController 
{
	@GetMapping
	public String method1()
	{
		return "get api called";
	}
	@PostMapping
	public String method2()
	{
		return "post api called";
	}
	@PutMapping
	public String method3()
	{
		return "put api called";
	}
	@DeleteMapping
	public String method4()
	{
		return "delete api called";
	}
}
