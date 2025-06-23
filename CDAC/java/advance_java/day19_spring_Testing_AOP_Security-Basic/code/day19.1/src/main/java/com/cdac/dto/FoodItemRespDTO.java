package com.cdac.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//lombok  annotations
@Getter
@Setter
@ToString(callSuper = true)
public class FoodItemRespDTO extends BaseDTO {
	private String itemName;
	private String itemDescription;
	private boolean isVeg;
	private int price;

}
