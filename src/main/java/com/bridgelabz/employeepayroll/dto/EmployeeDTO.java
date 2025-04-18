package com.bridgelabz.employeepayroll.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

public @Data class EmployeeDTO {
    @NotEmpty(message = "Employee name cannot by empty")
    @Pattern(regexp = "^[A-Z]{1}[A-Za-z\\s]$", message = "Employee name invalid")
    private String name;
    private double salary;
}
