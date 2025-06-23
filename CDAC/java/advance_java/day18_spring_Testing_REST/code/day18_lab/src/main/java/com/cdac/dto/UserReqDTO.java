package com.cdac.dto;

import java.time.LocalDate;

import com.cdac.entities.UserRole;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserReqDTO {

	private String firstName;

	private String lastName;

	private String email;

	private String password;

	private LocalDate dob;

	private UserRole role;
}
