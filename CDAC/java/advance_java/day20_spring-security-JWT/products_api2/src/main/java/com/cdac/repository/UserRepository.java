package com.cdac.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdac.entities.UserEntity;


public interface UserRepository extends JpaRepository<UserEntity, Long> {
//add a finder method - to find user by email
	Optional<UserEntity> findByEmail(String email);
}
