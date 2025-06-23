package com.cdac.vehicle.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TestUserRepository {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testCreateNewUser() {
        Assertions.assertTrue(userRepository.existsById(1L));
    }
}
