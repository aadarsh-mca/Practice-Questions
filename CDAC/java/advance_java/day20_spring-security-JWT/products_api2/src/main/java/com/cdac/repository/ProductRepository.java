package com.cdac.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdac.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
