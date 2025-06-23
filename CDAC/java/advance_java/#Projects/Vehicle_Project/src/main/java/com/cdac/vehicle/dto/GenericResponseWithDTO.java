package com.cdac.vehicle.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class GenericResponseWithDTO {
    private LocalDateTime timestamp;
    private String message;

    private List<GenericDTO> deletedData = new ArrayList<>();

    public GenericResponseWithDTO(String message, List<? extends GenericDTO> genericDTOList) {
        this.timestamp = LocalDateTime.now();
        this.message = message;
        this.deletedData.addAll(genericDTOList);
    }
}
