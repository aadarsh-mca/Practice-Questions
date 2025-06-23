package com.cdac.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdac.custom_exceptions.ResourceNotFoundException;
import com.cdac.dao.FoodItemDao;
import com.cdac.dao.RestaurantDao;
import com.cdac.dto.ApiResponse;
import com.cdac.dto.FoodItemReqDTO;
import com.cdac.dto.FoodItemRespDTO;
import com.cdac.entities.FoodItem;
import com.cdac.entities.Restaurant;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class FoodItemServiceImpl implements FoodItemService {
	// depcy

	private final FoodItemDao foodItemDao;
	private final RestaurantDao restaurantDao;
	private final ModelMapper modelMapper;

	@Override
	public FoodItem getFoodItemDetails(Long foodItemId) {

		return foodItemDao.findById(foodItemId)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Food Item ID!!!!!"));
	}

	@Override
	public String updateFoodItemDetails(Long id, String desc, double price) {
		// Option 1 - findById n 2 setters (select , update)
		// OR - update jpql

		return "Updated " + foodItemDao.updateFoodItemDetails(price, desc, id) + " food item";
	}

	@Override
	public ApiResponse addFoodItem(FoodItemReqDTO dto) {
		// 1. to do - validate if same food item exists under the same restaurant
		// 2. Get restaurant details by its id
		Restaurant restaurant = restaurantDao.findById(dto.getRestaurantId())
				.orElseThrow(() -> new ResourceNotFoundException("Invalid restaurant id - food item can't be added"));
		// 3 => restaurant exists : PERSISTENT
		// 4. map food item dto -> entity
		FoodItem entity = modelMapper.map(dto, FoodItem.class);
		// 5 establish bi dir asso between Restaurant 1 <---> * FoodItem
		restaurant.addFoodItem(entity);
		// no need of explicitly saving food item entity - due to cascading
		return new ApiResponse("food item added to restaurant");
	}

}
