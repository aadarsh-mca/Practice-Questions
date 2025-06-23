package com.cdac.entities;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tags")
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class Tag extends BaseEntity {
	@Column(length = 20, unique = true)
	private String name;
	// Tag *---->* Restaurant
	/*
	 * For better performance , in many-many , use Collection type as Set instead of
	 * List
	 */
	@ManyToMany(cascade = CascadeType.PERSIST)
	private Set<Restaurant> restaurants=new HashSet<>();
	//size=0 , init capacity=16, load factor=.75

	public Tag(String name) {
		super();
		this.name = name;
	}

}
