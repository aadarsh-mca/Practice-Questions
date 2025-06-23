package com.cdac.vehicle.repository;

import com.cdac.vehicle.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmail(String email);

    boolean existsByName(String name);

    Optional<User> findByName(String username);

//    @Query("Select u From User u Left Join Fetch u.vehicles Where u.name = :username")
//    Optional<User> findUserByIdWithAllVehicles(Long userId);

    @Query("Select u From User u Left Join Fetch u.vehicles Where u.name = :username")
    Optional<User> findByNameWithAllVehicles(String username);

}
