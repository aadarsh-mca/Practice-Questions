package com.cdac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdac.custom_exceptions.ApiException;
import com.cdac.custom_exceptions.ResourceNotFoundException;
import com.cdac.dao.RestaurantDao;
import com.cdac.dto.ApiResponse;
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
		return restaurantDao.findAll(); // List of persistent entities
	}// session.close -> L1 cache destroyed - entities -detached from L1

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
		if (restaurantDao.findByName(transientEntity.getName()).isEmpty())
			return restaurantDao.save(transientEntity);
		throw new ApiException("Dup restaurant name !!!!!!");
	} // when transactional method rets - tx over - tx .commit
		// service layer rets DETACHED entity to the caller

	@Override
	public Restaurant getById(Long restaurantId) {
		// TODO Auto-generated method stub
		return restaurantDao.findById(restaurantId)
				.orElseThrow(() -> 
				new ResourceNotFoundException("Invalid restuarant ID"));
	}

	@Override
	public Restaurant updateDetails(Long id, 
			Restaurant restaurant) {
		// validate restaurant id
		Restaurant restaurant2 = getById(id);
		//valid id -> continue to update
		return restaurantDao.save(restaurant);
	}//in case of success-> tx.commit -> DML : update -> sesison.close

	@Override
	public ApiResponse deleteDetails(String restaurantName) {
		Restaurant restaurant = restaurantDao
		.findByName(restaurantName)
		.orElseThrow(() -> new ResourceNotFoundException("No restaurant by the specified name!!!!!!"));
		//=> restaurant : persistent
		restaurantDao.delete(restaurant);//restaurant : REMOVED
		
		return new ApiResponse("Restaurant details deleted.....");
	}//no exc -> commit -> DML - delete . session.close -> l1 cache -> TRANSIENT
	

}
