package com.cdac.service;

import com.cdac.dto.AuthRequest;
import com.cdac.dto.UserReqDTO;
import com.cdac.dto.UserRespDTO;

public interface UserService {

	UserRespDTO registerUser(UserReqDTO dto);

	UserRespDTO authenticate(AuthRequest dto);

}
