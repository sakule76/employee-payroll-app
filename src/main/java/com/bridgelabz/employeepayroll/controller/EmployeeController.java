package com.bridgelabz.employeepayroll.controller;

import com.bridgelabz.employeepayroll.dto.ResponseDTO;
import com.bridgelabz.employeepayroll.model.Employee;
import com.bridgelabz.employeepayroll.service.EmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeeController {
    @Autowired
    private EmployeePayrollService employeeService;


    @GetMapping("/")
    public ResponseDTO getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return new ResponseDTO("Fetched all employees", employees);
    }

    @GetMapping("/get/{id}")
    public ResponseDTO getEmployeeById(@PathVariable long id) {
        Employee employee = employeeService.getEmployeeById(id);
        return new ResponseDTO("Fetched employee by ID", employee);
    }

    @PostMapping("/create")
    public ResponseDTO createEmployee(@RequestBody Employee employee) {
        Employee createdEmployee = employeeService.createEmployee(employee);
        return new ResponseDTO("Employee created successfully", createdEmployee);
    }

    @PutMapping("/update")
    public ResponseDTO updateEmployee(@RequestBody Employee employee) {
        Employee updatedEmployee = employeeService.updateEmployee(employee);
        return new ResponseDTO("Employee updated successfully", updatedEmployee);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDTO deleteEmployee(@PathVariable long id) {
        employeeService.deleteEmployee(id);
        return new ResponseDTO("Employee deleted successfully", "Deleted employee ID: " + id);
    }
}
