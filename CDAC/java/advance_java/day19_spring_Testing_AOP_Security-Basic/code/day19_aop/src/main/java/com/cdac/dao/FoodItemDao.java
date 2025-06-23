package com.cdac.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cdac.entities.FoodItem;

public interface FoodItemDao extends JpaRepository<FoodItem, Long> {
//add update JPQL
	@Query("update FoodItem f set f.price=:price ," + "f.itemDescription=:desc where f.id=:id")
	@Modifying
	int updateFoodItemDetails(double price, String desc, Long id);
	/*
	 * Get all food items by specific restaurant name - 
	 * i/p – resturant name -
	 * resp – List<Food item>
	 */
	List<FoodItem> findByMyRestaurantName
	(String name123);
	/*
	 * 11.3 Write a method   to get all 
	 * veg food items from specific restaurant by - restaurant id

	 */
	List<FoodItem> findByMyRestaurantIdAndIsVegTrue(Long restaurantId);
	
}
