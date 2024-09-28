package com.cetpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.cetpa","com.student"})
public class DataFormatApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataFormatApplication.class, args);
	}

}
