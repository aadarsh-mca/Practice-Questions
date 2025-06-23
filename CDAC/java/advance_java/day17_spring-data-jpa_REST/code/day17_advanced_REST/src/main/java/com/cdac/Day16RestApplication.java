package com.cdac;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Day16RestApplication {

	public static void main(String[] args) {
		SpringApplication.run(Day16RestApplication.class, args);
	}
	/*
	 * Configure ModelMapper as spring bean - so thar SC will manage it's life cycle
	 * + provide it as the depcy
	 */
	@Bean //method level annotation
	public ModelMapper modelMapper() {
		System.out.println("in model mapper creation");
		return new ModelMapper();
	}

}
