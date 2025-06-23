package com.cdac.entities.inheritance;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@DiscriminatorValue(value = "mgr")
@Getter
@Setter
@ToString
public class Manager extends Employee {
	private double bonus;
	@Column(length = 30)
	private String deptName;
	
}
