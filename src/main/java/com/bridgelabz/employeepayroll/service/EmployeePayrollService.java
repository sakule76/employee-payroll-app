package com.bridgelabz.employeepayroll.service;

import com.bridgelabz.employeepayroll.dto.EmployeeDTO;
import com.bridgelabz.employeepayroll.dto.ResponseDTO;
import com.bridgelabz.employeepayroll.model.Employee;
import com.bridgelabz.employeepayroll.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public ResponseDTO createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee(employeeDTO.getName(), employeeDTO.getSalary());
        employeeRepository.save(employee);
        return new ResponseDTO("Created Employee payroll data successfully", HttpStatus.CREATED , employee);
    }

    @Override
    public ResponseDTO getEmployeeById(long employeeId) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
        if(optionalEmployee.isPresent()) {
            return new ResponseDTO("Employee fetched successfully", HttpStatus.OK, optionalEmployee);
        } else {
            return new ResponseDTO("Employee not found", HttpStatus.NOT_FOUND, null);
        }
    }

    @Override
    public ResponseDTO updateEmployee(EmployeeDTO employeeDTO) {
        Optional<Employee> optionalEmployee = employeeRepository.findByName(employeeDTO.getName());
        if(optionalEmployee.isPresent()) {
            Employee updatedEmployee = optionalEmployee.get();

            updatedEmployee.setName(employeeDTO.getName());
            updatedEmployee.setSalary(employeeDTO.getSalary());

            employeeRepository.save(updatedEmployee);

            return new ResponseDTO("Employee data updated successfully", HttpStatus.OK, updatedEmployee);
        } else {
            return new ResponseDTO("Employee not found", HttpStatus.NOT_FOUND, null);
        }
    }

    @Override
    public ResponseDTO deleteEmployee(long employeeId) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);

        if(optionalEmployee.isPresent()) {
            Employee deletedEmployee = optionalEmployee.get();

            employeeRepository.delete(deletedEmployee);

            return new ResponseDTO("Employee deleted successfully", HttpStatus.OK, deletedEmployee);
        } else {
            return new ResponseDTO("Employee not found", HttpStatus.NOT_FOUND, null);
        }
    }

    @Override
    public ResponseDTO getAllEmployees() {
        List<Employee> allEmployees = employeeRepository.findAll();

        return new ResponseDTO("Employees fetched successfully", HttpStatus.OK, allEmployees);
    }
}