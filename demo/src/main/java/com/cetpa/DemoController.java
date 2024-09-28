package com.cetpa;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("demo")
public class DemoController
{
	@GetMapping("m1")
	public String method1()
	{
		System.out.println("Method1 called...");
		return "Welcome";
	}
}
