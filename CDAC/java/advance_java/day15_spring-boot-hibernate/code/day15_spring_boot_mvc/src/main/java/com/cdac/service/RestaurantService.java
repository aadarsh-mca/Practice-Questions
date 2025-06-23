package com.cdac.service;

import java.util.List;

import com.cdac.entities.FoodItem;
import com.cdac.entities.Restaurant;

public interface RestaurantService {
//add a method to get all restaurants
	List<Restaurant> getAllRestaurants();
	
	Restaurant getRestaurantById(Long id);
	
//	FoodItem getFoodItem();
}
