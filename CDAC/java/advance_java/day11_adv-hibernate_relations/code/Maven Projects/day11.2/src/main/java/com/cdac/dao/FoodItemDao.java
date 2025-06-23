package com.cdac.dao;

import com.cdac.entities.FoodItem;
import com.cdac.entities.Restaurant;

public interface FoodItemDao {
	String addFoodItemToResturant(Long restaurantId, FoodItem foodItem);;
}
