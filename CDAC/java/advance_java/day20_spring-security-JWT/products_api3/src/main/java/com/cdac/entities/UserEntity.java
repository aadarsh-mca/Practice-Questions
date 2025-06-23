package com.cdac.entities;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/*
 * User - class
id : Long
first name , last name, email ,password - String
dob - LocalDate
role : Enum 
image : byte[]
 */
/*
 * Mandatory annotation for hibernate to manage entity 
 * @Entity - class level 
 * @Id - for PK (unique id property - typically - ref type for easy null 
 * checking) - field level | getter level
 */
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "secure_users")
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = "password", callSuper = true)
public class UserEntity extends BaseEntity implements UserDetails{

	@Column(length = 20)
	private String firstName;
	@Column(length = 30)
	private String lastName;
	@Column(length = 30, unique = true)
	private String email;
	@Column(length = 300, nullable = false)
	private String password;
	private LocalDate dob;
	@Enumerated(EnumType.STRING)
	private UserRole role;
	//implement UserDetial i/f methods
	@Override
	public Collection<? extends GrantedAuthority> 
	getAuthorities() {
		// TODO Auto-generated method stub
		return List.of(new SimpleGrantedAuthority(role.name()));
	}//rets immutable List of roles - single role
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.email;
	}
	

}
