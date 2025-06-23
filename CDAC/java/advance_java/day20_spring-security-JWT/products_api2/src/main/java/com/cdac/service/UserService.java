package com.cdac.service;

import com.cdac.dto.ApiResponse;
import com.cdac.dto.UserReqDTO;

public interface UserService {
  ApiResponse signUp(UserReqDTO dto);
}
