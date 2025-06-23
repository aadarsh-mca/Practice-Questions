package com.cdac.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FoodItemReqDTO {
	private Long restaurantId;
	private String itemName;
	private String itemDescription;
	private boolean isVeg;
	private int price;
}
