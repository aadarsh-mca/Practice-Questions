package com.cdac.dto;

import lombok.Getter;
import lombok.Setter;

@Getter //used during  de- ser (DTO->Entity)
@Setter //used during  ser (Entity -> DTO)
public class RestaurantRespDTO extends BaseDTO{
	private String name;
	private String address;
	private String city;
	private String description;
	
}
