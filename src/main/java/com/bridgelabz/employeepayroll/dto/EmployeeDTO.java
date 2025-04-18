package com.bridgelabz.employeepayroll.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

public @Data class EmployeeDTO {

    @NotEmpty(message = "Employee name cannot be empty")
    @Pattern(regexp = "^[A-Z][a-zA-Z\\s]*$", message = "Employee name invalid")
    private String name;

    @Min(value = 500, message = "Minimum salary should be 500")
    private double salary;

    @Pattern(regexp = "male|female", message = "Gender needs to male or female")
    private String gender;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @NotNull(message = "Date cannot be empty")
    @PastOrPresent(message = "start end should be past or today's date")
    private LocalDate startDate;

    @NotBlank(message = "Profile pic cannot be empty")
    private String profilePic;

    private List<String> departments;
}
