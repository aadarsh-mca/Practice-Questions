package com.cdac.service;

import java.util.List;

import com.cdac.dto.ApiResponse;
import com.cdac.dto.RestaurantMenuDTO;
import com.cdac.dto.RestaurantReqDTO;
import com.cdac.dto.RestaurantRespDTO;
import com.cdac.entities.Restaurant;

public interface RestaurantService {
//add a method to get all restaurants
	List<RestaurantRespDTO> getAllRestaurants();
	
	
	//add a method to save new restaurant details
	RestaurantRespDTO addNewRestaurant(RestaurantReqDTO transientEntity);
	//add a method to get specific restaurant details
	RestaurantRespDTO getById(Long restaurantId);
	//add a method to get specific restaurant details + its menu
	RestaurantMenuDTO getRestaurantAndMenu(Long restaurantId);
	Restaurant updateDetails(Long id, Restaurant restaurant);
	ApiResponse deleteDetails(String restaurantName);
}
