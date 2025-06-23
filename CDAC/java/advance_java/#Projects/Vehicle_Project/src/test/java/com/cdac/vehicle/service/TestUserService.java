package com.cdac.vehicle.service;

import com.cdac.vehicle.dto.CreateUserDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class TestUserService {

    @Autowired
    private UserService userService;

    @Test
    public void testCreateNewUser() {
        /**
         *         UserDTO userDTO = new UserDTO(
         *                 null, null, null, null,
         *                 "name", LocalDate.parse("1999-09-01"), "email",  "password", "contact", "city" );
         *
         *
         *         User transientUser = new User(
         *                 "name", LocalDate.parse("1999-09-01"),
         *                 "email",  "password", "contact", "city",
         *                 new ArrayList<>()
         *         );
         */

        CreateUserDTO userDTO = new CreateUserDTO(
                null, null, null, null,
                "name", LocalDate.parse("1999-09-01"), "email",  "password", "contact", "city" );


        Assertions.assertEquals(true, userService.createNewUser(userDTO).getId() != null);
    }

}
