package com.cdac.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.dto.UserReqDTO;
import com.cdac.service.UserService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserSignUpSignInController {
	private UserService userService;

	@PostMapping("/signup")
	public ResponseEntity<?> signUpUser(@RequestBody @Valid UserReqDTO dto) {
		System.out.println("in sign up "+dto);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(userService.signUp(dto));
	}

}
