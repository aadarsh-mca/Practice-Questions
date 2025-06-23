package com.cdac.vehicle.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * User has the following attributes: (Enter Sample Data in Database)
	1)	Uid (unique identifier for each User)
	2)	Uname (Cannot be Blank)
	3)	Email (Cannot be Blank)
	4)	Password (Cannot be blank, min 6 characters)
	5)	City (Cannot be Blank)
	6)	Contact_No (Cannot be blank, min 10 digit)
	7)	Birth_Date(Cannot be Blank)
 * 
 */

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {
	
	@Column(length = 50, nullable = false)
	private String name;
	
	@Column(name = "date_of_birth", nullable = false)
	private LocalDate dob;
	
	@Column(length = 50, nullable = false)
	private String email;
	
	@Column(length = 32, nullable = false, columnDefinition = "VARCHAR(32) CHECK ( LENGTH(password) >= 6)")
	private String password;
	
	@Column(name = "contact_no", length = 10, nullable = false)
	private String contactNo;
	
	@Column(length = 15, nullable = false)
	private String city;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Vehicle> vehicles = new ArrayList<>();

	public void addNewVehicle(Vehicle vehicle) {
		this.vehicles.add(vehicle);
		vehicle.setUser(this);
	}

	public void removeVehicle(Vehicle vehicle) {
		this.vehicles.remove(this.vehicles.indexOf(vehicle));
		vehicle.setUser(null);
	}
}
