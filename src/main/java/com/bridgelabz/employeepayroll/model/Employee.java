package com.bridgelabz.employeepayroll.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@Entity
public @Data class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="employee_id")
    private long employeeId;

    @Column(name="name")
    private String name;

    private double salary;
    private String gender;
    private LocalDate startDate;
    private String profilePic;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "employee_department", joinColumns = @JoinColumn(name = "employee_id"))
    @Column(name="department")
    private List<String> departments;

    public Employee(String name, double salary, String gender, LocalDate startDate, String profilePic, List<String> departments) {
        this.name = name;
        this.salary = salary;
        this.gender = gender;
        this.startDate = startDate;
        this.profilePic = profilePic;
        this.departments = departments;
    }
}
