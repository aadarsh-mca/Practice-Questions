package com.cdac.vehicle.entities;

import java.time.LocalDate;

import com.cdac.vehicle.enums.Brand;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * Vehicle has the following attributes: 
	1)	Id (unique identifier for each Vehicle, auto generated, starts from 1)
	2)	Vname (Cannot be Blank, Example: Splendor, Amaze, Pulsar, etc.)
	3)	Company (Enum, Example: Hero, Honda, Bajaj, etc.)
	4)	Vnumber (Cannot be Blank, Example: MH09AB1111, MH10CD2222, MHEF3333, etc.)
	5)	Vtype (Cannot be Blank, Example: bike, sedan, cruiser, etc.)
	6)	Uid (User ID, FK)
	7)	purchaseDate(Cannot be Blank)
 * 
 */

@Entity
@Table(name = "vehicles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle extends BaseEntity {
	
	@Column(nullable = false)
	private String name;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Brand brand;
	
	@Column(name = "registration_no", nullable = false)
	private String regNo;
	
	@Column(nullable = false)
	private String type;
	
	@Column(nullable = false)
	private LocalDate purchaseDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

}
