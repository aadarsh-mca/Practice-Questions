package com.cdac.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.entities.Restaurant;
import com.cdac.service.RestaurantService;

@RestController  // mandatory - @Controller + @ResponseBody
@RequestMapping("/restaurant")
public class RestaurantController {
	
	@Autowired  // default - byType
	private RestaurantService restaurantService;

	public RestaurantController() {
		System.out.println("====== [ In Constructor " + getClass() + " ] ======");
	}
	
	/**
	 * REST API endpoint
	 * URL - http://host:port/restaurant/all-restaurants
	 * Method - GET
	 * Payload - none
	 * ResponseBody - List<Restaurant>
	 */
	@GetMapping("/all")
//	@GetMapping("/restaurant")
	public ResponseEntity<?> fetchAllRestaurant() {
		System.out.println("=== [ In GET of All Restaurants ] ===");

		List<Restaurant> restaurants = restaurantService.getAllRestaurants();
		
		/**
		 * In case of NO Restaurants :: 
		 * 		Status Code : 204
		 * 
		 * In case of Restaurants :: 
		 * 		Status Code : 200
		 * 		Body : List<Restaurant>
		 */
		
		ResponseEntity<List<Restaurant>> response;
		
		
		if(restaurants.isEmpty()) {
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
//			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			response = new ResponseEntity<List<Restaurant>>(restaurants, HttpStatus.OK);
			
//			return ResponseEntity.ok(restaurants);
		}
		
		return response;
//		return restaurantService.getAllRestaurants();
	}
		
}
