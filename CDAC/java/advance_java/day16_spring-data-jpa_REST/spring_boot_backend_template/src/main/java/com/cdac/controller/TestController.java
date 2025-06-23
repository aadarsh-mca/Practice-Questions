package com.cdac.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Controller -- Class Level Annotation
 *     +   
 * @ResponseBody -- annotation for serialization (Java -> JSON | XML)
 */
//@RestController

@RestController
@RequestMapping("/dummy")
public class TestController {
	
	public TestController() {
		System.out.println("=== [ In Constructor " + getClass() + " ] ===");
	}
	
	/**
	 * REST API end point
	 * 
	 * URL - http://host:port/dummy
	 * 
	 * Method - GET 
	 * Payload - none
	 * Response Body - List of numbers 
	 */
	@GetMapping
	public /* ResponseBody */ List<Integer> testDummyEndpoint() {
		System.out.println("=== [ In Test Dummy ] ===");
		
		return List.of(10, 20, 30, 40);
	}
	
}
