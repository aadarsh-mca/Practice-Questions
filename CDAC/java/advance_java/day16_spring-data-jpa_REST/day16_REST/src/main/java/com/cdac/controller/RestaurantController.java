package com.cdac.controller;

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

@RestController // mandatory - @Controller + @RespBody
@RequestMapping("/restaurants")
public class RestaurantController {
	// depcy
	@Autowired // byType
	private RestaurantService restaurantService;

	public RestaurantController() {
		System.out.println("in ctor " + getClass());
	}

	/*
	 * Add REST API endpoint URL - http://host:port/restaurants Method - GET Payload
	 * - none Response - Body - List<Restaurant>
	 * 
	 */
	@GetMapping
	public /* @ResponseBody */ ResponseEntity<?> getAllRestaurants() {
		System.out.println("in get all restaurants");
		List<Restaurant> restaurants = restaurantService.getAllRestaurants();
		/*
		 * in case of no restaurants - SC 204 in case of restaurants - SC 200 + List -
		 * resp body
		 */
		if (restaurants.isEmpty())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		// Resp packet - SC 204 , NO resp body !!!!!
		// => restaurants exist
		return ResponseEntity.ok(restaurants);
		// resp pkt - SC 200 , body - JSON representation of list

	}

	/*
	 * Add REST API endpoint to add new restaurant URL -
	 * http://host:port/restaurants Method - POST Payload - JSON representation of
	 * Restaurant (JSON -> Java : de serial = un marshalling - @RequestBody)
	 * Response - Body - Restaurant -> ser -> @RespBody
	 * 
	 */
	@PostMapping
	public ResponseEntity<?> addNewRestaurant
	(@RequestBody Restaurant restaurant) {
		System.out.println("in add rest " + restaurant);// all details except id
		//invoke service layer method
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(restaurantService
						.addNewRestaurant(restaurant));
	}
}
