package com.cdac.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.dto.ApiResponse;
import com.cdac.dto.AuthRequest;
import com.cdac.dto.AuthResponse;
import com.cdac.dto.UserReqDTO;
import com.cdac.service.UserService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserSignUpSignInController {
	private final UserService userService;
	private final AuthenticationManager authenticationManager;

	@PostMapping("/signup")
	public ResponseEntity<?> signUpUser(@RequestBody @Valid UserReqDTO dto) {
		System.out.println("in sign up " + dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.signUp(dto));
	}

	/*
	 * User sign in URL - http://host:port/users/signin Method - POST Payload - JSON
	 * representation of auth req dto (email , pwd) Response -User resp dto | error
	 * - api resp with err mesg
	 * 
	 */
	@PostMapping("/signin")
	public ResponseEntity<?> userSignIn(@RequestBody @Valid AuthRequest dto) {
		System.out.println("in signin " + dto);
		// 1.create auth token
		UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword());
		
		try {
			// 2. invoke AuthMgr's authenticate
			Authentication retAuth = authenticationManager.authenticate(authToken);
			System.out.println(retAuth.isAuthenticated());//true
			System.out.println(retAuth.getPrincipal());
			System.out.println(retAuth.getPrincipal().getClass());
			//success
			return ResponseEntity.status(HttpStatus.CREATED) //JWT - created
					.body(new AuthResponse("Auth successful!!!","jwt will appear soon......"));
		} catch (Exception e) {
			System.out.println(e);
			return ResponseEntity
					.status(HttpStatus.UNAUTHORIZED)
					.body(new ApiResponse(e.getMessage()));
		}

	}

}
