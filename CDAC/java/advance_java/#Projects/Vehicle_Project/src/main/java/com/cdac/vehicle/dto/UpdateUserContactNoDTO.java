package com.cdac.vehicle.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserContactNoDTO {

    private LocalDateTime updatedOn;

    @NotNull
    @NotBlank(message = "New Contact No is required")
    private String contactNo;

}
