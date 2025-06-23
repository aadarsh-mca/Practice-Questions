package com.cdac.controller;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/test") // class level optional BUT reco annotation
public class TestController {

    private final HelloWordController helloWordController;
	public TestController(HelloWordController helloWordController) {
		System.out.println("in ctor " + getClass());
		this.helloWordController = helloWordController;
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
	//add req handling method to test model map
	@GetMapping("/test2")
	public String testModelMap(Model modelMap) {
		System.out.println("in test model map "+modelMap);//{}
		//add model attributes
		modelMap.addAttribute("server_date", LocalDate.now())
		.addAttribute("server_time", LocalTime.now());
		return "test/display2";//AVN - /WEB-INF/views/test/display2.jsp
	}
	/*
	 * Handler rets explicitly - LVN -> D.S
	 * SC implicitly - model map -> D.S
	 */
	
	
	
	
}
