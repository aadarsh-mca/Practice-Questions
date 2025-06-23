package com.cdac.dto;

import java.time.LocalDate;

import com.cdac.entities.UserRole;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class UserRespDTO extends BaseDTO{

	private String firstName;

	private String lastName;

	private String email;	

	private LocalDate dob;

	private UserRole role;
}
