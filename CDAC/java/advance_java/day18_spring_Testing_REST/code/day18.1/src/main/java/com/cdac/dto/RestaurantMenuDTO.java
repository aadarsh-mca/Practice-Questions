package com.cdac.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class RestaurantMenuDTO {
	private RestaurantRespDTO restaurant;
	private List<FoodItemRespDTO> foodItems;

}
