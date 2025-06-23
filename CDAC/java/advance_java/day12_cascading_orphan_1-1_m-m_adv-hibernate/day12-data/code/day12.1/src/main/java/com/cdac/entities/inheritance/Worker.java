package com.cdac.entities.inheritance;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@DiscriminatorValue("worker")
@Getter
@Setter
@ToString
public class Worker extends Employee {

	private int noOfHours;
	private double rate;
}
