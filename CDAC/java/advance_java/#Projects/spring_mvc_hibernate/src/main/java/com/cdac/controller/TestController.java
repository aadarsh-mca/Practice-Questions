package com.cdac.controller;

import java.time.LocalTime;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/test")  // class level optional but recommended
public class TestController {

    private final HelloWorldController helloWorldController;

	public TestController(HelloWorldController helloWorldController) {
		System.out.println("====== [ In Constructor :: " + getClass() + " ] ======");
		this.helloWorldController = helloWorldController;
	}
	
	/**
	 * Add request mapping method 
	 * to return dynamic result using ModelAndView
	 */
	@GetMapping("/test1")
	public ModelAndView testModelAndView() {
		System.out.println("=== [ Inside testModelAndView() ] ===");
		
		/**
		 *  			 	LVN 	"attr-name"	   "attr-value"
		 * ModelAndView( viewName, modelAttrName, modelAttrValue )
		 */
		return new ModelAndView("test/display", "server_time", LocalTime.now());
	}
}
