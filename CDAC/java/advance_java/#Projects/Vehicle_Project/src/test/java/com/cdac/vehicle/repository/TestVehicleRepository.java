package com.cdac.vehicle.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TestVehicleRepository {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Test
    public void testFindByUserId() {
        Assertions.assertEquals(true, vehicleRepository.findByUserId(1L) != null);
    }


}
