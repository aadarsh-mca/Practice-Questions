package com.cdac.vehicle.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class CreateVehicleDTO {

    /**
     *
     * Properties used for Serialization ONLY
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
     * Properties used for De-serialization ONLY
     *
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String name;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String brand;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String regNo;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String type;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private LocalDate purchaseDate;

    /**
     * <ul>
     * <li>Either create custom setter to make Brand String uppercase</li>
     * <pre>    Or</pre>
     * <li>Use Brand Enum data type instead of String data type</li>
     * </ul>
     * @param brand
     */
    public void setBrand(String brand) {
        this.brand = brand.toUpperCase();
    }
}
