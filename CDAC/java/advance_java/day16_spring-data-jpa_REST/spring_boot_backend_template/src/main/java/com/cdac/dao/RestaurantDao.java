package com.cdac.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cdac.entities.Restaurant;

public interface RestaurantDao extends JpaRepository<Restaurant, Long> {
	//add a custom query to fetch restaurant + menu details -
	//in single left outer join query
//	 @Query("select r from Restaurant r left join fetch r.foodItems where r.id=:id")
//	 Optional<Restaurant> fetchRestaurantAndMenu(Long id);
	
}
