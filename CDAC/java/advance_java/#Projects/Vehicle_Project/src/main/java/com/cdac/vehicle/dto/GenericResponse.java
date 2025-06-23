package com.cdac.vehicle.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class GenericResponse {
    private LocalDateTime timestamp;
    private String message;

    public GenericResponse(String message) {
        this.timestamp = LocalDateTime.now();
        this.message = message;
    }
}
