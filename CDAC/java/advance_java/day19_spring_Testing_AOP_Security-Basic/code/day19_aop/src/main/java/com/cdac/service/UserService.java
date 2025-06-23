package com.cdac.service;

import java.time.LocalDate;
import java.util.List;

import com.cdac.dto.AuthRequest;
import com.cdac.dto.UserReqDTO;
import com.cdac.dto.UserRespDTO;

import jakarta.validation.constraints.Past;

public interface UserService {

	UserRespDTO registerUser(UserReqDTO dto);

	UserRespDTO authenticate(AuthRequest dto);

	List<UserRespDTO> getUsersByDate(LocalDate dob);

}
