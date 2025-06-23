package com.cdac.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor //added only for writing test cases
@NoArgsConstructor
public class AuthRequest {
	@NotBlank
	private String email;
	@NotBlank
	private String password;
}
