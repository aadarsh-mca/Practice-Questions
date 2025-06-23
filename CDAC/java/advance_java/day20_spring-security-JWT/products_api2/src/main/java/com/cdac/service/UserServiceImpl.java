package com.cdac.service;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdac.dto.ApiResponse;
import com.cdac.dto.UserReqDTO;
import com.cdac.entities.UserEntity;
import com.cdac.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {
	private UserRepository userRepository;
	private ModelMapper modelMapper;
	private PasswordEncoder encoder;

	@Override
	public ApiResponse signUp(UserReqDTO dto) {
		// 0. validate if email is dup
		// 1. convert dto -> entity
		UserEntity userEntity = modelMapper.map(dto, UserEntity.class);
		userEntity.setPassword(encoder.encode(userEntity.getPassword()));
		//save entity
		UserEntity persistenEntity = userRepository.save(userEntity);
		return 
				new ApiResponse("User registered with ID " + persistenEntity.getId());
	}

}
