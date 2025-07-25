package com.cdac.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class AddressReqDTO  {
	
	private String adrLine1;
	
	private String adrLine2;
	
	private String city;
	
	private String state;
	
	private String country;
	
	private String zipCode;
		
}
