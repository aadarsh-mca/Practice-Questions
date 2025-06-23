package com.cdac.vehicle.controller;

import com.cdac.vehicle.exception.MissingRequestParameterException;
import com.cdac.vehicle.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }


    /**
     * <pre>
     * URL - http://host:port/vehicles?userId=
     * Method - GET
     * Payload - {}
     * Response - ResponseEntity< List<ShowVehicleDTO> >
     * Error - {}
     * </pre>
     */
    @GetMapping
    public ResponseEntity<?> getAllVehiclesByUserId(
            @RequestParam(name = "userId", required = false) Long userId,
            @RequestParam(name = "username", required = false) String username
    ) {
        if(userId != null || username != null) {
            if(userId != null) {
                return ResponseEntity.ok(vehicleService.getAllVehiclesByUserId(userId));
            }
            return ResponseEntity.ok(vehicleService.getAllVehiclesByUserName(username));
        }
        throw new MissingRequestParameterException("userId", "username");
    }

    /**
     * <pre>
     * URL - http://host:port/vehicles/{date}
     * Method - GET
     * Payload - {}
     * Response - ResponseEntity< List<ShowVehicleDTO> >
     * Error - {}
     * </pre>
     */
    @GetMapping("/{date}")
    public ResponseEntity<?> getAllVehicleSoldOnWithUser(@PathVariable LocalDate date) {
        return ResponseEntity.ok(vehicleService.getAllVehiclesBySellingDateWithUser(date));
    }






}
