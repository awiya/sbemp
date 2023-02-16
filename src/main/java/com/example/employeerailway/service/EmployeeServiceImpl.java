package com.example.employeerailway.service;

import com.example.employeerailway.dto.EmployeeDTO;
import com.example.employeerailway.model.Employee;
import com.example.employeerailway.repository.EmployeeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {



    private final EmployeeRepo employeeRepo;
    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepo.findAll().stream().map(employee -> fromEmployee(employee)).toList();
    }

    private EmployeeDTO fromEmployee(Employee employee) {
        EmployeeDTO employeeDTO = EmployeeDTO.builder()
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .email(employee.getEmail())
                .build();

        return employeeDTO;
    }

    @Override
    public EmployeeDTO getEmployeeById(Long id) {
        return null;
    }

    @Override
    public Employee createEmployee(EmployeeDTO employeeDTO) {
        return null;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return null;
    }

    @Override
    public void deleteEmployee(Long id) {

    }
}
