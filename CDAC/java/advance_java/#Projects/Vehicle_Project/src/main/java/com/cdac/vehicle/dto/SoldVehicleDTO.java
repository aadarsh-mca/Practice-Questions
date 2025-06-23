package com.cdac.vehicle.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class SoldVehicleDTO {

    private String owner;

    private String model;

    private String regNo;
}
