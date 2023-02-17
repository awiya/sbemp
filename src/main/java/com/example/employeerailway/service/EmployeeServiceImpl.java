package com.example.employeerailway.service;

import com.example.employeerailway.dto.EmployeeDTO;
import com.example.employeerailway.model.Employee;
import com.example.employeerailway.repository.EmployeeRepo;
import lombok.RequiredArgsConstructor;
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



    @Override
    public EmployeeDTO getEmployeeById(Long id) {
        Employee employee = employeeRepo.findById(id).orElseThrow(()->new RuntimeException("Employee not found"));
        EmployeeDTO employeeDTO = fromEmployee(employee);
        return employeeDTO;
    }

    @Override
    public Employee createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = fromEmployeeDTO(employeeDTO);
        return null;
    }



    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepo.deleteById(id);
    }

    private Employee fromEmployeeDTO(EmployeeDTO employeeDTO) {
        Employee employee = Employee.builder()
                .firstName(employeeDTO.getFirstName())
                .lastName(employeeDTO.getLastName())
                .email(employeeDTO.getEmail())
                .build();
        return  employee;
    }

    private EmployeeDTO fromEmployee(Employee employee) {
        EmployeeDTO employeeDTO = EmployeeDTO.builder()
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .email(employee.getEmail())
                .build();
        return employeeDTO;
    }
}
