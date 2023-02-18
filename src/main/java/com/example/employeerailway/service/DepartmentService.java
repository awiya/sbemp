package com.example.employeerailway.service;

import com.example.employeerailway.dto.DepartmentDTO;
import com.example.employeerailway.model.Department;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(DepartmentDTO departmentDTO);

    List<DepartmentDTO> getAllDepartments();

    DepartmentDTO getDepartmentById(Long id);

    Department updateDepartment(Department department, Long id);

    void deleteDepartment(Long id);

    DepartmentDTO findDepartmentById(String name);

    List<DepartmentDTO> fetchDepartmentsByNameContains(String s);
}
