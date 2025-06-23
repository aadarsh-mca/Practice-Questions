package com.cdac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cdac.service.RestaurantService;

@Controller
@RequestMapping("/restaurants")
public class RestaurantController {

	private final HelloWordController helloWordController;
	// Depcy
	@Autowired
	private RestaurantService restaurantService;

	RestaurantController(HelloWordController helloWordController) {
		this.helloWordController = helloWordController;
	}

	// add req handling method -
	// to share result(list of restaurants) with the view layer
	// URL - http://host:port/ctx_path/restaurants/list
	@GetMapping("/list")
	public String renderRestaurantList(Model map) {
		System.out.println("in render list " + map);// {}
		map.addAttribute("restaurant_list", restaurantService.getAllRestaurants());
		return "restaurants/list";
	}

	/*
	 * Handler rets -> LVN + model map -> D.S D.S -> LVN -> V.R -> AVN
	 * (/WEB-INF/views/restaurants/list.jsp -> D.S -> adds model attr under req
	 * scope -> forwards -> JSP -> ${....}
	 */
	// add request handling method - to render specific restaurant
	/*
	 * URL - http://host:port/ctx_path/restaurants/details?restaurant_id=.... Method
	 * - GET
	 */
	@GetMapping("/details")
	public String getRestaurantById(@RequestParam Long restaurant_id, Model modelAttrMap)

	{
		System.out.println("in get restarunt dtls " + restaurant_id + " " + modelAttrMap);
		// invoke service layer method
		modelAttrMap.addAttribute
		("restaurant_dtls", 
				restaurantService.getRestaurantDetails(restaurant_id));
		return "restaurants/details";
		//AVN - /WEB-INF/views/restaurants/details.jsp
	}

}
