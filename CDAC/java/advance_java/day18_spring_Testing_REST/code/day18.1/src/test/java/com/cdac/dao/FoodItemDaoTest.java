package com.cdac.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.cdac.entities.FoodItem;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class FoodItemDaoTest {
	
	@Autowired
	private FoodItemDao foodItemDao;

	@Test
	void testFindByRestaurantName() {
		List<FoodItem> foodItems = foodItemDao.findByMyRestaurantName("Shree Misal House");
		
		foodItems.forEach(System.out::println);
		
		assertEquals(3, foodItems.size());
	}
	
	@Test
	void testFindByMyRestaurantIdAndVegIsTrue() {
		List<FoodItem> foodItems1 = foodItemDao.findByMyRestaurantIdAndIsVegTrue(1L);
//		List<FoodItem> foodItems2 = foodItemDao.findByMyRestaurantIdAndIsVeg(1L, true);
		
		foodItems1.forEach(System.out::println);
		
		assertEquals(false, foodItems1.isEmpty());
	}

}
