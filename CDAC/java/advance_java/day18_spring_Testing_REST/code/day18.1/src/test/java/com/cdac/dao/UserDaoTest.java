package com.cdac.dao;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.cdac.entities.User;

/**
 * 
 * DAO Layer Test
 * 
 */

/**
 * Mandatory
 * 
 * Tell SpringBoot test container about --> following is DAO layer test
 */
@DataJpaTest

/**
 * To Continue with same Database as SpringBoot (main app --> application.properties)
 */
@AutoConfigureTestDatabase(replace = Replace.NONE)
class UserDaoTest {  // test class
	
	@Autowired
	private UserDao userDao;

	/**
	 * Mandatory --> Method Level Annotation
	 * 
	 * To indicate JUnit test case method 
	 */
	@Test
	void testFindByEmailAndPassword() {  // test case
//		Optional<User> optionalUser = userDao.findByEmailAndPassword("email", "password");
//		
//		Assertions.assertEquals(true, optionalUser.isPresent());
	}
	
	

}
