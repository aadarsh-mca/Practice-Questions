package com.cdac.vehicle.controller;

import com.cdac.vehicle.dto.CreateVehicleDTO;
import com.cdac.vehicle.dto.CreateUserDTO;
import com.cdac.vehicle.dto.UpdateUserContactNoDTO;
import com.cdac.vehicle.service.UserService;
import com.cdac.vehicle.service.VehicleService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final VehicleService vehicleService;

    @Autowired
    public UserController(UserService userService, VehicleService vehicleService) {
        this.userService = userService;
        this.vehicleService = vehicleService;
    }

    /**
     *
     *
     * User-Centric Users endpoints
     *
     *
     */

    /**
     * <pre>
     * URL - http://host:port/users
     * Method - GET
     * Payload - {}
     * Response - ResponseEntity<List<UserDTO>>
     * Error - {}
     * </pre>
     */
    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    /**
     * <pre>
     * URL - http://host:port/users/{userId}
     * Method - GET
     * Payload - {}
     * Response - ResponseEntity<UserDTO>
     * Error - {}
     * </pre>
     */
    @GetMapping("/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.getUserById(userId));
    }


    /**
     * <pre>
     * URL - http://host:port/users
     * Method - POST
     * Payload - {
     *     'name': User-Name,
     *     'dob': 1999-09-01,
     *     'email': example@gmail.com,
     *     'contactNo': 9876543210,
     *     'city': Delhi,
     * }
     * Response - ResponseEntity<UserDTO>
     *     with New User Created and User-ID
     * Error - {}
     * </pre>
     */
    @PostMapping
    public ResponseEntity<?> createNewUser(@RequestBody CreateUserDTO userDTO) {
        return ResponseEntity.ok(userService.createNewUser(userDTO));
    }


    /**
     * <pre>
     * URL - http://host:port/users/{userId}/contact-no
     * Method - PUT
     * Payload - {
     *     'contactNo': 9876543210
     * }
     * Response - ResponseEntity<ShowUserDTO>
     * Error - {}
     * </pre>
     */
    @PatchMapping("/{userId}/contact-no")
    public ResponseEntity<?> updateUserContactNo(
            @PathVariable Long userId,
            @Valid @RequestBody @NotNull UpdateUserContactNoDTO contactNoDTO
    ) {
        return ResponseEntity.ok(userService.updateUserContactNo(userId, contactNoDTO));
    }


    /**
     *
     *
     * User-Centric Vehicles endpoints
     *
     *
     */


    /**
     * Adding a new vehicle in User's Vehicle list
     *
     * <pre>
     * URL - http://host:port/users/{userId}/vehicles
     * Method - POST
     * Payload - {
     *   "name": "vehicle_name",
     *   "brand": "brand_enum",
     *   "regNo": "XX-XX-XXXX",
     *   "type": "vehicle_catgeory",
     *   "purchaseDate": "yyyy-MM-dd"
     * }
     * Response - ResponseEntity< CreateVehicleDTO >
     * Error - {}
     * </pre>
     */
    @PostMapping("/{userId}/vehicles")
    public ResponseEntity<?> addUserNewVehicle(@PathVariable Long userId, @RequestBody CreateVehicleDTO vehicleDTO) {
        return ResponseEntity.ok(vehicleService.addNewVehicleUsingUserId(userId, vehicleDTO));
    }


    /**
     * Getting vehicle using vehicleId and userName
     *
     * <pre>
     * URL - http://host:port/users/{username}/vehicles/{vehicleId}
     * Method - GET
     * Payload - {}
     * Response - ResponseEntity< List<ShowVehicleDTO> >
     * Error - {}
     * </pre>
     */
    @GetMapping("/{username}/vehicles/{vehicleId}")
    public ResponseEntity<?> getVehicleByIdAndUserName(@PathVariable String username, @PathVariable Long vehicleId) {
        return ResponseEntity.ok(vehicleService.getVehicleByIdAndUserName(vehicleId, username));
    }


    /**
     * <pre>
     * URL - http://host:port/users/{username}/vehicles
     * Method - GET
     * Payload - {}
     * Response - ResponseEntity< ShowVehicleDTO >
     * Error - {}
     * </pre>
     */
    @DeleteMapping("/{username}/vehicles")
    public ResponseEntity<?> deleteAllVehiclesByUserName(@PathVariable String username) {
        return ResponseEntity.ok(userService.deleteAllVehicleFromUserByName(username));
    }




}
