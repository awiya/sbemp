package com.example.employeerailway.service;

import com.example.employeerailway.dto.EmployeeDTO;
import com.example.employeerailway.model.Employee;

import java.util.List;

public interface EmployeeService {

    public List<EmployeeDTO> getAllEmployees();
    public EmployeeDTO getEmployeeById(Long id);
    public Employee createEmployee(EmployeeDTO employeeDTO);
    public Employee updateEmployee(Employee employee);
    public void deleteEmployee(Long id);

}
