package com.cdac.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdac.custom_exceptions.ApiException;
import com.cdac.custom_exceptions.ResourceNotFoundException;
import com.cdac.dao.RestaurantDao;
import com.cdac.dto.ApiResponse;
import com.cdac.dto.RestaurantMenuDTO;
import com.cdac.dto.RestaurantReqDTO;
import com.cdac.dto.RestaurantRespDTO;
import com.cdac.entities.Restaurant;

import lombok.AllArgsConstructor;

@Service // => spring bean containing B.L
@Transactional // => auto tx management
@AllArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

	// depcy	
	private final RestaurantDao restaurantDao;
	// depcy	
	private final ModelMapper modelMapper;

	@Override
	public List<RestaurantRespDTO> getAllRestaurants() {
		
		return restaurantDao.findAll() //List<Restaurant>
				.stream() //Stream<Restaurant>
				.map(restaurant -> modelMapper.map(restaurant, RestaurantRespDTO.class)) //Stream<dto>
				.collect(Collectors.toList());//List<DTO>				
	}
	
	@Override
	public RestaurantRespDTO addNewRestaurant(
			RestaurantReqDTO dto) {
		/*
		 * validate if the restaurant name already exists 
		 * -yes - throw custom exception
		 * - name alrdy exists - no continue
		 */
		if (restaurantDao.findByName
				(dto.getName()).isEmpty()) {
			//convert dto -> entity , for persistence
			Restaurant entity=modelMapper.map(dto,Restaurant.class);
			 return modelMapper.map(restaurantDao.save(entity)
					 , RestaurantRespDTO.class);
		}
		throw new ApiException("Dup restaurant name !!!!!!");
	} // when transactional method rets - tx over - tx .commit
		// service layer rets DETACHED entity to the caller

	@Override
	public RestaurantRespDTO getById(Long restaurantId) {
		// TODO Auto-generated method stub
		Restaurant entity = restaurantDao.findById(restaurantId)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid restuarant ID"));
		// entity -> dto
		return modelMapper.map
				(entity, RestaurantRespDTO.class);
	}

	@Override
	public Restaurant updateDetails(Long id, Restaurant restaurant) {
		// validate restaurant id
		Restaurant restaurant2 = restaurantDao.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid restuarant ID"));

		// valid id -> continue to update
		return restaurantDao.save(restaurant);
	}// in case of success-> tx.commit -> DML : update -> sesison.close

	@Override
	public ApiResponse deleteDetails(String restaurantName) {
		Restaurant restaurant = restaurantDao.findByName(restaurantName)
				.orElseThrow(() -> new ResourceNotFoundException("No restaurant by the specified name!!!!!!"));
		// => restaurant : persistent
		restaurantDao.delete(restaurant);// restaurant : REMOVED

		return new ApiResponse("Restaurant details deleted.....");
	}

	@Override
	public RestaurantMenuDTO getRestaurantAndMenu
	(Long restaurantId) {
		Restaurant restaurant = 
				restaurantDao.fetchRestaurantAndMenu(restaurantId)
				.orElseThrow(
						() -> new ResourceNotFoundException("Invalid restuarant ID"));
		//=> at least - restaurant exists -> map it to DTO
		return modelMapper.map(restaurant, RestaurantMenuDTO.class);
	}// no exc -> commit -> DML - delete . session.close -> l1 cache -> TRANSIENT
	
	

}
