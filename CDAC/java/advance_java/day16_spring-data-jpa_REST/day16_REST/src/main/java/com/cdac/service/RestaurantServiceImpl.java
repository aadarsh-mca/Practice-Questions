package com.cdac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdac.custom_exceptions.ApiException;
import com.cdac.custom_exceptions.ResourceNotFoundException;
import com.cdac.dao.RestaurantDao;
import com.cdac.entities.Restaurant;

@Service // => spring bean containing B.L
@Transactional // => auto tx management
public class RestaurantServiceImpl implements RestaurantService {

	// depcy
	@Autowired
	private RestaurantDao restaurantDao;

	@Override
	public List<Restaurant> getAllRestaurants() {
		// TODO Auto-generated method stub
		return restaurantDao.findAll();
	}

	@Override
	public Restaurant getRestaurantDetails(Long restaurantId) {

//		Restaurant restaurant = restaurantDao.fetchRestaurantAndMenu(restaurantId)
//				.orElseThrow(
//						() -> 
//						new ResourceNotFoundException
//						("Invalid Restaurnat ID - not found !!!!!"));
		// => valid id , restaurant : persistent
		// simply access the size of the collection
		// restaurant.getFoodItems().size();//triggers another select query - food_items
		return null;
	}

	@Override
	public Restaurant addNewRestaurant(Restaurant transientEntity) {
		/*
		 * validate if the restaurant name already exists -yes - throw custom exception
		 * - name alrdy exists - no continue
		 */
		if (restaurantDao.findByName(
				transientEntity.getName()).isEmpty())
			return restaurantDao.save(transientEntity);
		throw new ApiException("Dup restaurant name !!!!!!");
	} // when transactional method rets - tx over - tx .commit
		// service layer rets DETACHED entity to the caller

}
