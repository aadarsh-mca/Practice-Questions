package com.cdac.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.cdac.entities.User;

//dao layer test
@DataJpaTest //mandatory annotation to tell 
//Spring Boot test container  - following is DAO later test
//to continue with same DB - as spring boot 
//main app (app properties)
@AutoConfigureTestDatabase(replace = Replace.NONE)
class UserDaoTest {
	//depcy - user dao
	@Autowired
	private UserDao userDao;

	@Test //mandatory method level annotation 
	//-for  JUnit- to indicate a test case 
	void testFindByEmailAndPassword() {
		Optional<User> optional = 
				userDao.findByEmailAndPassword
				("a1@gmail.com", "3412345");
		assertEquals(true, optional.isPresent());
	}

}
