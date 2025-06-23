package com.cdac.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdac.custom_exceptions.ApiException;
import com.cdac.dao.UserDao;
import com.cdac.dto.AuthRequest;
import com.cdac.dto.UserReqDTO;
import com.cdac.dto.UserRespDTO;
import com.cdac.entities.User;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {
	// depcy
	private final UserDao userDao;
	private final ModelMapper modelMapper;

	@Override
	public UserRespDTO registerUser(UserReqDTO dto) {
		// validate if email is not dup
		if (userDao.existsByEmail(dto.getEmail()))
			throw new ApiException("Dup Email !!!!!!!!");
		// => email : distinct
		// map dto -> entity
		User entity = modelMapper.map(dto, User.class);
		return modelMapper.map
				(userDao.save(entity), UserRespDTO.class);
	}

	@Override
	public UserRespDTO authenticate(AuthRequest dto) {
		User user=userDao.findByEmailAndPassword
				(dto.getEmail(), dto.getPassword())
				.orElseThrow(() -> 
				new ApiException("Invalid email or password!!!!"));
		return modelMapper.map(user, UserRespDTO.class);
	}

	@Override
	public List<UserRespDTO> getUsersByDate(LocalDate dob) {
		
		return userDao.findByDobAfter(dob) //List<Entity>
				.stream() //Stream<Entity>
				.map(entity -> modelMapper.map(entity,UserRespDTO.class)) //Stream<DTO>
				.collect(Collectors.toList());
				
	}
	
	
	
	

}
