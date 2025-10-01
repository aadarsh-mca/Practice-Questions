package com.cdac.vehicle.service;

import com.cdac.vehicle.dto.*;
import com.cdac.vehicle.entities.User;
import com.cdac.vehicle.entities.Vehicle;
import com.cdac.vehicle.exception.DuplicateResourceFoundException;
import com.cdac.vehicle.exception.ResourceNotFoundException;
import com.cdac.vehicle.repository.UserRepository;
import com.cdac.vehicle.repository.VehicleRepository;
import jakarta.servlet.GenericServlet;
import jakarta.servlet.Servlet;
import jakarta.servlet.http.HttpServlet;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

//    Servlet
//    GenericServlet
//    HttpServlet

    private final UserRepository userRepository;
    private final VehicleRepository vehicleRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, VehicleRepository vehicleRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.vehicleRepository = vehicleRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ShowUserDTO> getAllUsers() {
        List<User> listOfUsers = userRepository.findAll();

        if(listOfUsers.isEmpty()) {
            throw new ResourceNotFoundException("No User found !!!");
        }

        return listOfUsers.stream()
                .map(user -> modelMapper.map(user, ShowUserDTO.class))
                .toList();
    }

    @Override
    public ShowUserDTO getUserById(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("No User found with the given ID " + userId));;

        return modelMapper.map(user, ShowUserDTO.class);
    }

    @Override
    public CreateUserDTO createNewUser(CreateUserDTO userDTO) {
        User newUser = modelMapper.map(userDTO, User.class);

        if(userRepository.existsByEmail(newUser.getEmail())) {
            throw new DuplicateResourceFoundException("User already exists with the given Email ID '" + userDTO.getEmail() + "' !!!");
        }

        newUser = userRepository.save(newUser);

        userDTO = modelMapper.map(newUser, CreateUserDTO.class);
        userDTO.setMessage("New user created successfully !!!");

        return userDTO;
    }

    @Override
    public UpdateUserContactNoDTO updateUserContactNo(Long userId, UpdateUserContactNoDTO contactNoDTO) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("No User found with the given ID " + userId));

        user.setContactNo(contactNoDTO.getContactNo());
        /**
         * No need to explicitly flush,
         * as value is directly changed in
         */
        userRepository.flush();
        return  modelMapper.map(user, UpdateUserContactNoDTO.class);
    }

    //    @Override
//    public List<ShowVehicleDTO> getUserByNameWithAllVehicles(String username) {
//        User user = userRepository.findByNameWithAllVehicles(username)
//                .orElseThrow(() -> new ResourceNotFoundException("No User found with the given name " + username));
//
//
//        return user.getVehicles().stream()
//                .map(vehicle -> modelMapper.map(vehicle, ShowVehicleDTO.class))
//                .toList();
//    }

    @Override
    public GenericResponseWithDTO deleteAllVehicleFromUserByName(String username) {
        User user = userRepository.findByNameWithAllVehicles(username)
                .orElseThrow(() -> new ResourceNotFoundException("No User found with the given name " + username));

        List<Vehicle> vehicleList = user.getVehicles();

        if(vehicleList.isEmpty()) {
            throw new ResourceNotFoundException("No Vehicle found for the given User Name " + username + " !!!");
        }

        List<Vehicle> deletedVehicleList = new ArrayList<>(user.getVehicles());

//        vehicleList.forEach(vehicle -> vehicle.setUser(null));
        vehicleList.clear();
/*
vehicleRepository.delete(vehicleList.getFirst());
vehicleList.removeFirst();
*/
        List<ShowVehicleDTO> listOfShowVehicleDTO = deletedVehicleList.stream()
                .map(vehicle -> modelMapper.map(vehicle, ShowVehicleDTO.class))
                .toList();
        return new GenericResponseWithDTO(
                "All the Vehicles owned by " + username + " has been deleted successfully !!!",
                listOfShowVehicleDTO
        );
    }
}
