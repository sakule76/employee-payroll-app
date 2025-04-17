package com.bridgelabz.employeepayroll.service;

import com.bridgelabz.employeepayroll.model.Employee;
import com.bridgelabz.employeepayroll.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeePayrollService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            return employee.get();
        } else {
            throw new RuntimeException("Employee with ID " + id + " not found.");
        }
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Employee employee) {
        if (employeeRepository.existsById(employee.getEmployeeId())) {
            return employeeRepository.save(employee);
        } else {
            throw new RuntimeException("Cannot update. Employee with ID " + employee.getEmployeeId() + " not found.");
        }
    }

    public void deleteEmployee(long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
        } else {
            throw new RuntimeException("Employee with ID " + id + " not found.");
        }
    }
}

