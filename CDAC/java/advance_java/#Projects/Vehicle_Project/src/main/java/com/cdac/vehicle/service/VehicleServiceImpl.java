package com.cdac.vehicle.service;

import com.cdac.vehicle.dto.CreateVehicleDTO;
import com.cdac.vehicle.dto.ShowUserDTO;
import com.cdac.vehicle.dto.ShowVehicleDTO;
import com.cdac.vehicle.dto.SoldVehicleDTO;
import com.cdac.vehicle.entities.User;
import com.cdac.vehicle.entities.Vehicle;
import com.cdac.vehicle.exception.DuplicateResourceFoundException;
import com.cdac.vehicle.exception.ResourceNotFoundException;
import com.cdac.vehicle.repository.UserRepository;
import com.cdac.vehicle.repository.VehicleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public VehicleServiceImpl(VehicleRepository vehicleRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.vehicleRepository = vehicleRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ShowVehicleDTO> getAllVehiclesByUserId(Long userId) {
        if(userRepository.existsById(userId) == false) {
            throw new ResourceNotFoundException("No User found with the given ID " + userId);
        }

        List<Vehicle> listOfVehicles = vehicleRepository.findAllByUserId(userId);

        if(listOfVehicles.isEmpty()) {
            throw new ResourceNotFoundException("No Vehicle Found !!!");
        }

        return listOfVehicles.stream()
                .map(vehicle -> modelMapper.map(vehicle, ShowVehicleDTO.class))
                .toList();
    }

    @Override
    public List<ShowVehicleDTO> getAllVehiclesByUserName(String username) {
        if(userRepository.existsByName(username) == false) {
            throw new ResourceNotFoundException("No User found with the given name " + username);
        }

        List<Vehicle> listOfVehicles = vehicleRepository.findAllByUserName(username);

        if(listOfVehicles.isEmpty()) {
            throw new ResourceNotFoundException("No Vehicle Found !!!");
        }

        return listOfVehicles.stream()
                .map(vehicle -> modelMapper.map(vehicle, ShowVehicleDTO.class))
                .toList();
    }

    @Override
    public CreateVehicleDTO addNewVehicleUsingUserId(Long userId, CreateVehicleDTO createVehicleDTO) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Unknown User with given ID " + userId));

        Vehicle vehicle = modelMapper.map(createVehicleDTO, Vehicle.class);

        if(vehicleRepository.existsByRegNo(vehicle.getRegNo())) {
            throw new DuplicateResourceFoundException("Vehicle already present with the given Registration No. '" + vehicle.getRegNo() + "' !!!");
        }

        user.addNewVehicle(vehicle);

        /**
         * Explicitly flushing the changes
         * to get Persisted Vehicle Entity details
         * Else
         * getting null values
         */
        userRepository.flush();

        createVehicleDTO = modelMapper.map(vehicle, CreateVehicleDTO.class);
        createVehicleDTO.setMessage("Vehicle with Registration No. '" + createVehicleDTO.getRegNo() + "' is successfully added for User ID " + userId + " !!!");
        return createVehicleDTO;
    }

    @Override
    public ShowVehicleDTO getVehicleByIdAndUserName(Long vehicleId, String username) {
        if(userRepository.existsByName(username) == false) {
            throw new ResourceNotFoundException("No User found with the given Name " + username);
        }

        Vehicle vehicle = vehicleRepository.findByIdAndUserName(vehicleId, username)
                .orElseThrow(() -> new ResourceNotFoundException("No Vehicle present for given Vehicle ID " + vehicleId + " and User Name " + username + " !!!"));

        return modelMapper.map(vehicle, ShowVehicleDTO.class);
    }

    /**
     *
     *
     */
    @Override
    public List<SoldVehicleDTO> getAllVehiclesBySellingDateWithUser(LocalDate date) {
        List<Vehicle> listOfAllVehicleBySellingDate = vehicleRepository.findAllByPurchaseDate(date);

        if(listOfAllVehicleBySellingDate.isEmpty()) {
            throw new ResourceNotFoundException("No Vehicle sold on the given date " + date + " !!!");
        }

        List<SoldVehicleDTO> soldVehicleDTOList = new ArrayList<>();

        listOfAllVehicleBySellingDate.forEach(
                soldVehicle -> {
                    User user = soldVehicle.getUser();
                    soldVehicleDTOList.add(new SoldVehicleDTO(user.getName(), soldVehicle.getName(), soldVehicle.getRegNo()));
//                    ShowUserDTO currShowUserDTO = modelMapper.map(soldVehicle.getUser(), ShowUserDTO.class);
//                    ShowVehicleDTO currShowVehicleDTO = modelMapper.map(soldVehicle, ShowVehicleDTO.class);
//
//                    boolean userAlreadyAdded = false;
//                    for(SoldVehicleDTO soldVehicleDTO : soldVehicleDTOList) {
//                        if(soldVehicleDTO.getUser() != null && soldVehicleDTO.getUser().getId().equals(currShowUserDTO.getId())) {
//                            soldVehicleDTO.getVehicle().add(currShowVehicleDTO);
//                            userAlreadyAdded = true;
//                            break;
//                        }
//                    }
//
//                    if(userAlreadyAdded == false) {
//                        List<ShowVehicleDTO> newShowVehicleDTOList =  new ArrayList<>();
//                        newShowVehicleDTOList.add(currShowVehicleDTO);
//                        soldVehicleDTOList.add(new SoldVehicleDTO(currShowUserDTO, newShowVehicleDTOList));
//                    }
                });

        return soldVehicleDTOList;
    }
}
