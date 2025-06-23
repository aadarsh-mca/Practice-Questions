package com.cdac.dto;

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
	private String email;
	private String password;
}
