package com.cdac.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdac.customExceptions.ResourceNotFoundException;
import com.cdac.dao.RestaurantDao;
import com.cdac.entities.FoodItem;
import com.cdac.entities.Restaurant;

@Service //=> spring bean containing B.L
@Transactional //=> auto tx management
public class RestaurantServiceImpl implements RestaurantService {

	//depcy 
	@Autowired
	private RestaurantDao restaurantDao;
	
	@Override
	public List<Restaurant> getAllRestaurants() {
		return restaurantDao.findAll();
	}
	
	public Restaurant getRestaurantById(Long id) {
//		Optional<Restaurant> restaurant = restaurantDao.findById(id);
//		
//		if(restaurant.isPresent()) {
//			restaurant.get().getFoodItems().size();
//			return restaurant.get();
//		} else {
//			return null;
//		}
		
		Restaurant restaurant = restaurantDao.findById(id).orElseThrow();
		restaurant.getFoodItems().size();
		
		return restaurant;
	}

//	@Override
//	public FoodItem getFoodItem() {
//		
//	}
	
	
	

}

class SupplierImpl<T> implements Supplier<T> {

	@Override
	public T get() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
