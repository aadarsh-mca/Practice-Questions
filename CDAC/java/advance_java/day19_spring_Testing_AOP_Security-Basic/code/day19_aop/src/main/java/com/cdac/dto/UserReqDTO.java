package com.cdac.dto;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Length;

import com.cdac.entities.UserRole;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserReqDTO {
	@NotBlank(message = "first name is required !!!")
	private String firstName;
	
	@NotBlank(message = "last name is required !!!")
	@Length(min=3,max=15,message = "invalid no of chars in last name")
	private String lastName;
	@Email(message = "invalid email format !")
	private String email;
	@Pattern(regexp="((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})",
			message = "Invalid password format !!!")
	private String password;
	@NotNull(message = "dob is required")
	@Past
	private LocalDate dob;
	@NotNull
	private UserRole role;
}
