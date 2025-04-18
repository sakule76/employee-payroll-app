package com.bridgelabz.employeepayroll.service;

import com.bridgelabz.employeepayroll.dto.EmployeeDTO;
import com.bridgelabz.employeepayroll.dto.ResponseDTO;

public interface IEmployeePayrollService {
    ResponseDTO createEmployee(EmployeeDTO employeeDTO);
    ResponseDTO updateEmployee(EmployeeDTO employeeDTO);
    ResponseDTO getEmployeeById(long employeeId);
    ResponseDTO deleteEmployee(long employeeId);
    ResponseDTO getAllEmployees();
    ResponseDTO getEmployeesByDepartment(String department);
}
