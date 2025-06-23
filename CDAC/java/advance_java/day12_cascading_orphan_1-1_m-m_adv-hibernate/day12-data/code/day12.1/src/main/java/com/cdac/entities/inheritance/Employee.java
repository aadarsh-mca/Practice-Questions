package com.cdac.entities.inheritance;


import com.cdac.entities.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Inheritance//(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "emp_type")
@Table(name = "employees")
@Getter
@Setter
@ToString
public class Employee extends BaseEntity{
	
	@Column(unique = true,length = 30)
	private String name;
	private double salary;
	
}
