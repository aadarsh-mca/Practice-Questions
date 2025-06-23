package com.cdac.vehicle.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class ShowUserDTO {
    private Long id;

    private LocalDateTime updatedOn;

    private String name;

    private LocalDate dob;

    private String email;

    private String contactNo;

    private String city;
}
