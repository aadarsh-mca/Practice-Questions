package com.cdac.controller;

import java.time.LocalTime;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/test") // class level optional BUT reco annotation
public class TestController {
	public TestController() {
		System.out.println("in ctor " + getClass());
	}
	//add req handling method to ret dynamic result 
	//using ModelAndView
	@GetMapping("/test1") //=@RequestMapping(Method=GET) : doGet
	public ModelAndView testModelAndView() {
		System.out.println("in test model n view");
		/*
		 * Ctor of o.s.w.s.ModelAndView(String lvn , 
		 * String modelAttrName,Object modelAttrValue)
		 */
		return new ModelAndView("test/display", 
				"server_time",
				LocalTime.now());
	}
	
	
	
	
}
