package com.cdac.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class RestaurantMenuDTO {
//	private RestaurantRespDTO restaurant;	
	private String name;
	private String address;
	private String city;
	private String description;
	private List<FoodItemRespDTO> foodItems;

}
