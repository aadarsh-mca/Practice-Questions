package com.cdac.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Getter //used during  de- ser (DTO->Entity)
@Setter //used during  ser (Entity -> DTO)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class RestaurantRespDTO extends BaseDTO{
	private String name;
	private String address;
	private String city;
	private String description;
	
}
