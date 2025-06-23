package com.cdac.service;

import com.cdac.dto.AddressReqDTO;
import com.cdac.dto.ApiResponse;

public interface AddressService {

	ApiResponse assignUserAddress(Long userId, AddressReqDTO dto);

}
