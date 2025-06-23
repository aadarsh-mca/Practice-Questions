package com.cdac.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // mandatory class level annotation to tell SC , following
//is a request handling controller - spring bean
//singleton n eager
public class HelloWordController {

	public HelloWordController() {
		System.out.println("in ctor " + getClass());
	}

	// add request handling method - service
	@RequestMapping("/")
	/*
	 * Method level annotation - mandatory 
	 * - to map incoming request (url pattern) to 
	 * Handler's (Req handling controller) method
	 * - can intercept ANY (get|post|put....) HTTP method
	 * - equivalent to service(rq,rs) in servlet
	 * Usage - SC will auto add the entry in HandlerMapping bean
	 * Key -  / (value of req mapping annotation)
	 * Value - F.Q Handler class name.methodName
	 */
	public String sayHello() {
		System.out.println("in say hello");
		return "index";
	}

}
