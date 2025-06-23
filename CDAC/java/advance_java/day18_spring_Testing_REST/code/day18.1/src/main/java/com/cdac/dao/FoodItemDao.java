package com.cdac.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cdac.entities.FoodItem;

public interface FoodItemDao extends JpaRepository<FoodItem,Long> {
//add update JPQL
	@Modifying
	@Query("update FoodItem f set f.price=:price, f.itemDescription=:desc where f.id=:id")
	int updateFoodItemDetails(double price,String desc,Long id);
	
//	@Query("Select f From FoodItem f Where f.myRestaurant.name=:name")
	List<FoodItem> findByMyRestaurantName(String restaurantName);

	List<FoodItem> findByMyRestaurantIdAndIsVegTrue(Long id);
//	List<FoodItem> findByMyRestaurantIdAndIsVeg(Long id, boolean isVeg);
}
