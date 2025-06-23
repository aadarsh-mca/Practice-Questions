package com.cdac.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cdac.dao.FoodItemDao;
import com.cdac.dto.FoodItemReqDTO;
import com.cdac.service.FoodItemService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/food_items")
@AllArgsConstructor
public class FoodItemController {

  
	private final FoodItemService foodItemService;


    
	
	 
	 /*
	  *   Add new food item to the restaurant(Important)
	 	 *  URL - http://host:port/food_items
	 	 * Method - POST 
	 	 * Payload - JSON representation of FoodItemReq dto 
	 	 * Response -  FoodItemRespDTO 
	 	 * 
	  */
	@PostMapping
	@Operation(description ="Add new food item to the restaurant")
	public ResponseEntity<?> addFoodItemToRestaurant(
			@RequestBody FoodItemReqDTO dto)
	{
	  System.out.println("add food item "+dto);
	  return ResponseEntity.status(HttpStatus.CREATED)
			  .body(foodItemService.addFoodItem(dto));
	}
	


}
