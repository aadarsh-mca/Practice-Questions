package com.cdac.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cdac.dto.AuthRequest;
import com.cdac.dto.UserRespDTO;

@SpringBootTest
class TestUserService {
	//D.I - auto wiring byType - field level
	@Autowired
	private UserService userService;

	@Test
	void testAuthenticate() {
		AuthRequest dto=new AuthRequest("a1@gmail.com", "12345");
		UserRespDTO respDto = userService.authenticate(dto);
		assertEquals(1,respDto.getId());
	}

}
