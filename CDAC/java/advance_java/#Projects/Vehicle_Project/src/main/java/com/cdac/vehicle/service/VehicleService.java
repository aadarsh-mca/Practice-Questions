package com.cdac.vehicle.service;

import com.cdac.vehicle.dto.CreateVehicleDTO;
import com.cdac.vehicle.dto.ShowVehicleDTO;
import com.cdac.vehicle.dto.SoldVehicleDTO;

import java.time.LocalDate;
import java.util.List;

public interface VehicleService {

    List<ShowVehicleDTO> getAllVehiclesByUserId(Long userId);

    List<ShowVehicleDTO> getAllVehiclesByUserName(String username);

    CreateVehicleDTO addNewVehicleUsingUserId(Long userId, CreateVehicleDTO vehicleDTO);

    ShowVehicleDTO getVehicleByIdAndUserName(Long vehicleId, String username);

    List<SoldVehicleDTO> getAllVehiclesBySellingDateWithUser(LocalDate date);
}
