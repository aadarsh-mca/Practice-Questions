package com.cdac.service;

import com.cdac.dto.FoodItemRespDTO;
import com.cdac.dto.ApiResponse;
import com.cdac.dto.FoodItemReqDTO;
import com.cdac.entities.FoodItem;

public interface FoodItemService {
	FoodItem getFoodItemDetails(Long foodItemId);

	String updateFoodItemDetails(Long id, String desc, double price);

	ApiResponse addFoodItem(FoodItemReqDTO dto);
}
