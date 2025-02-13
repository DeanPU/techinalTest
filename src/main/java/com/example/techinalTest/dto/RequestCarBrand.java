package com.example.techinalTest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RequestCarBrand {
    @NotBlank(message = "Name cannot be blank")
    @Size(max = 100, message = "Name cannot exceed 100 characters")
    private String name;

    @NotBlank(message = "Country cannot be blank")
    @Size(max = 50, message = "Country cannot exceed 50 characters")
    private String country;

    @JsonProperty("founded_year")
    @Min(value = 1, message = "Founded year must greater than 0")
    private Integer foundedYear;

    @Size(max = 255, message = "Description cannot exceed 255 characters")
    private String description;
}
