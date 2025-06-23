package com.cdac.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdac.custom_exceptions.ResourceNotFoundException;
import com.cdac.dao.AddressDao;
import com.cdac.dao.UserDao;
import com.cdac.dto.AddressReqDTO;
import com.cdac.dto.ApiResponse;
import com.cdac.entities.Address;
import com.cdac.entities.User;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class AddressServiceImpl implements AddressService {
	//depcy 
	private final AddressDao addressDao;
	private final UserDao userDao;
	private ModelMapper modelMapper;

	@Override
	public ApiResponse assignUserAddress(Long userId,
			AddressReqDTO dto) {
		// 1. get user from its id
		User user=userDao.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid user id !!!!!"));
		//user : persistent
		//2. dto -> entity
		Address addressEntity = modelMapper.map
				(dto, Address.class);
		//3. establish uni dir asso User 1---->1 Address
		user.setMyAddress(addressEntity);
		return new ApiResponse("address linked to user ....");
	}

}
