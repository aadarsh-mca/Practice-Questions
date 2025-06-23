package com.cdac.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.dto.AddressReqDTO;
import com.cdac.dto.ApiResponse;
import com.cdac.dto.AuthRequest;
import com.cdac.dto.UserReqDTO;
import com.cdac.service.AddressService;
import com.cdac.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
	private final UserService userService;
	private final AddressService addressService;
	 /*
	  *   User sign up
	 	 *  URL - http://host:port/users
	 	 * Method - POST 
	 	 * Payload - JSON representation of user req dto
	 	 * Response -  user resp dto
	 	 * 
	  */
	@PostMapping
	public ResponseEntity<?> userRegistration
	(@RequestBody UserReqDTO dto) {
		System.out.println("in reg user "+dto);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(userService.registerUser(dto));
	}
	
	 /*
	  *   Assign user address
	 	 *  URL - http://host:port/users/{userId}/address
	 	 * Method - POST 
	 	 * Payload - JSON representation of address req dto
	 	 * Response -  api resp 
	 	 * 
	  */
	@PostMapping("/{userId}/address")
	@Operation(description = "Assign User address")
	public ResponseEntity<?> assignUserAddress(
			@PathVariable Long userId,
			@RequestBody AddressReqDTO dto) {
		System.out.println("in add adr "+userId+" "+dto);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(addressService.assignUserAddress(userId,dto));
	}
	
	/*
	  *   User sign in 
	 	 *  URL - http://host:port/users/signin
	 	 * Method - POST 
	 	 * Payload - JSON representation of auth req dto (email , pwd)
	 	 * Response -User resp dto | error -   api resp with err mesg
	 	 * 
	  */
	@PostMapping("/signin")
	public ResponseEntity<?> userSignIn
	(@RequestBody AuthRequest dto)
	{
		System.out.println("in signin "+dto);
		try {
		return ResponseEntity.ok(userService.authenticate(dto));
		} catch (RuntimeException e) {
			return ResponseEntity
					.status(HttpStatus.UNAUTHORIZED)
					.body(new ApiResponse(e.getMessage()));
		}
	}
	

}
