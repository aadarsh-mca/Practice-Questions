package com.cdac.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.dto.ApiResponse;
import com.cdac.dto.RestaurantReqDTO;
import com.cdac.dto.RestaurantRespDTO;
import com.cdac.entities.Restaurant;
import com.cdac.service.RestaurantService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;

@RestController // mandatory - @Controller + @RespBody
@RequestMapping("/restaurants")
@AllArgsConstructor
public class RestaurantController //immutable
{

    	
	// depcy	 - using Ctor based D.I
	private final RestaurantService restaurantService;   
	
	/*
	 * Desc - Add REST API endpoint to get all restaurants
	 *  URL - http://host:port/restaurants 
	 *  Method - GET 
	 *  Payload - none 
	 *  Response - Body - List<Restaurant>
	 * 
	 */
	@GetMapping
	@Operation(description = "Get All restaurants")
	public /* @ResponseBody */ ResponseEntity<?> getAllRestaurants() {
		System.out.println("in get all restaurants");
		List<RestaurantRespDTO> restaurants =
				restaurantService.getAllRestaurants();
		/*
		 * in case of no restaurants - SC 204 in case of restaurants - SC 200 + List -
		 * resp body
		 */
		if (restaurants.isEmpty())
			return ResponseEntity.status(
					HttpStatus.NO_CONTENT).build();
		// Resp packet - SC 204 , NO resp body !!!!!
		// => restaurants exist
		return ResponseEntity.ok(restaurants);
		// resp pkt - SC 200 , body - JSON representation of list

	}

	/*
	 * Add REST API endpoint to add new restaurant 
	 * URL - http://host:port/restaurants 
	 * Method - POST 
	 * Payload - JSON representation of  Restaurant DTO(JSON -> Java : de serial = un marshalling - @RequestBody)
	 * Response - Body - RestaurantDTO -> ser -> @RespBody
	 * 
	 */
	@PostMapping
	@Operation(description = "Add new restaurant")
	public ResponseEntity<?> addNewRestaurant(
			@RequestBody RestaurantReqDTO restaurant) {
		System.out.println("in add rest " + restaurant);// all details except id
		try {
			// invoke service layer method
			return ResponseEntity.status
					(HttpStatus.CREATED)
					.body(restaurantService
							.addNewRestaurant(restaurant));
		} catch (RuntimeException e) {
			return ResponseEntity.status
					//in case of dup restaurant name either 400 or 409 => conflict
					(HttpStatus.CONFLICT)
					.body(new ApiResponse(e.getMessage()));
		}
	}

	/*
	 * Desc - Get restaurant details by ID URL -
	 * http://host:port/restaurants/{restaurantId} Method - GET payload - none Resp
	 * - JSON representation of restaurant
	 */
	@GetMapping("/{restaurantId}")
	@Operation(description = "Get Restaurant details by its ID")
	public ResponseEntity<?> getRestaurantDetailsById(
			@PathVariable Long restaurantId) {
		System.out.println("in get " + restaurantId);
		try {
			return ResponseEntity
					.ok(restaurantService.getById(restaurantId));
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
	}

	/*
	 * Desc - Update restaurant details by ID URL -
	 * http://host:port/restaurants/{restaurantId} Method - PUT payload - json
	 * representation of restaurant Resp - JSON representation of updated restaurant
	 */
	@PutMapping("/{id}")
	public ResponseEntity<?> updateRestuarantDetails(@PathVariable Long id, @RequestBody Restaurant restaurant) {
		System.out.println("in update " + id + " " + restaurant);
		return ResponseEntity.ok(restaurantService.updateDetails(id, restaurant));
	}
	/*
	 *  Delete restaurant details by name
	URL - http://host:port/restaurants/{restaurantName} - template URI variable
	Method -DELETE
	Payload -none (no request body !)
	success - Resp - DTO : ApiResp - SC 200 , mesg
	error resp - ApiResp - SC 404 ,err mesg
	 */
	@DeleteMapping("/{restaurantName}")
	public ResponseEntity<?> deleteRestaurantDetails(
			@PathVariable String restaurantName) {
		System.out.println("in delete "+restaurantName);
		try {
			return ResponseEntity
					.ok(restaurantService.
							deleteDetails(restaurantName));
		} catch (RuntimeException e) {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body(new ApiResponse(e.getMessage()));
		}
	}
	/*
	 * Desc - Get restaurant details + its menu  by restaurant ID 

	 *URL -  http://host:port/restaurants/{restaurantId}/menu
	 * Method - GET 
	 * payload - none  , path var - id
	 * Success Resp - JSON representation of DTO 
	 * - restaurant + food items
	 * Err resp - Api resp - with err mesg , SC - 404
	 */
	@GetMapping("/{restaurantId}/menu")
	@Operation(description = "Get restaurant details + its menu  by restaurant ID")
	public ResponseEntity<?> getRestaurantAndMenu(@PathVariable Long restaurantId)
	{
		System.out.println("in restaurant n menu "+restaurantId);
		return ResponseEntity.ok
				(restaurantService.
						getRestaurantAndMenu(restaurantId));
	}
}
