package com.cdac.vehicle.repository;

import com.cdac.vehicle.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    boolean existsByRegNo(String regNo);

    List<Vehicle> findAllByUserId(Long userId);
//    @Query("Select v From Vehicle v Where v.user.id = :userId")
//    List<Vehicle> findAllByUserId(Long userId);

    List<Vehicle> findAllByUserName(String name);

    Optional<Vehicle> findByIdAndUserName(Long vehicleId, String username);

    List<Vehicle> findAllByPurchaseDate(LocalDate date);


}
