package com.cdac.vehicle.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ShowVehicleDTO implements GenericDTO {

    private String name;

    private String brand;

    private String regNo;

    private String type;

    private LocalDate purchaseDate;

}
