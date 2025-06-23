package com.cdac.vehicle.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserDTO {

    /**
     *
     * Properties Used only for Serialization
     *
     */
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDate createdOn;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime updatedOn;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String message;

    /**
     *
     * Properties Used only for De-serialization
     *
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String name;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private LocalDate dob;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String contactNo;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String city;

}
