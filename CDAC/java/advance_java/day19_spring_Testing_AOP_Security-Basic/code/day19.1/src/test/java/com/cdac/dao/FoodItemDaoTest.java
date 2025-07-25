package com.cdac.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.cdac.entities.FoodItem;

@DataJpaTest //entity classes n dao layer -will be scanned
@AutoConfigureTestDatabase(replace = Replace.NONE)
// By default - all DAO layer's  test methods are transactional.
//at the end of the method - the tx is rolled back i.e 
//@Rollback(true)
class FoodItemDaoTest {
	@Autowired
	private FoodItemDao foodItemDao;

	@Test
	void testFindByMyRestaurantName() {
		List<FoodItem> list = foodItemDao
				.findByMyRestaurantName("Shree Misal House");
		list.forEach(System.out::println);
		assertEquals(2, list.size());
	}
	@Test
	void testFindByMyRestaurantIdAndIsVegTrue()
	{
		List<FoodItem> list = foodItemDao
				.findByMyRestaurantIdAndIsVegTrue(1l);
	//	list.forEach(System.out::println);
		assertEquals(1, list.size());
	}

}
