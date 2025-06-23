package com.cdac.controller;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * mandatory class level annotation to tell SpringContainer, following is a request handling controller - SpringBean
 */
@Component
@Controller 
public class HelloWorldController {

	public HelloWorldController() {
		System.out.println("====== [ In Constructor :: " + getClass() + " ] ======");
	}
	
	/**
	 * Method level annotation -- mandatory
	 * -- to map incoming request (url-pattern) to Request Handling Controller method
	 * -- can intercept any http method 
	 * -- equivalent to service(request, response) in servlet
	 * 
	 * -- Spring Container automatically add the entry in HandlerMapping Bean
	 * Key --> /
	 * Value --> fully-qualified handler.className.methodName :: com.cdac.HelloWorldController.sayHello()
	 */
	@RequestMapping("/")
	public String sayHello() {
		System.out.println("=== [ Inside sayHello() ] ===");
		
		/**
		 * returning the response as Logical View Name
		 */
		return "index";
	}

	
}
