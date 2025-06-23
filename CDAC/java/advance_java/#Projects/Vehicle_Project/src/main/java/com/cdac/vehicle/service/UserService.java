package com.cdac.vehicle.service;

import com.cdac.vehicle.dto.GenericResponseWithDTO;
import com.cdac.vehicle.dto.CreateUserDTO;
import com.cdac.vehicle.dto.ShowUserDTO;
import com.cdac.vehicle.dto.UpdateUserContactNoDTO;

import java.util.List;

public interface UserService {

    List<ShowUserDTO> getAllUsers();

    ShowUserDTO getUserById(Long userId);

    CreateUserDTO createNewUser(CreateUserDTO userDTO);

    UpdateUserContactNoDTO updateUserContactNo(Long userId, UpdateUserContactNoDTO contactNoDTO);

//    List<ShowVehicleDTO> getUserByNameWithAllVehicles(String username);

    GenericResponseWithDTO deleteAllVehicleFromUserByName(String username);

}
