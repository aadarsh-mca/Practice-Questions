package com.cdac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cdac.entities.Restaurant;
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
	 * Handler rets -> LVN + model map -> D.S
	 * D.S -> LVN -> V.R -> AVN (/WEB-INF/views/restaurants/list.jsp
	 * -> D.S -> adds model attr under req scope -> forwards -> JSP
	 * -> ${....}
	 */
	
	/**
	 * Add Request Handling method - to render specific restaurant
	 * 
	 * Url : http://host:port/ctx_path/restaurants/details?restaurant_id={}
	 */
	
	@GetMapping("/details")
	public String redirectToRestaurantDetail(@RequestParam Long restaurant_id, Model model) {
		Restaurant restaurant = restaurantService.getRestaurantById(restaurant_id);
		
		System.out.println("Restaurant :: " + restaurant);
		System.out.println("Food Items :: " + restaurant.getFoodItems());
		
		model.addAttribute("restaurant_details", restaurant);
		
		model.addAttribute("food_items", restaurant.getFoodItems());
		
		return "/restaurants/details";
	}
	
	

}
