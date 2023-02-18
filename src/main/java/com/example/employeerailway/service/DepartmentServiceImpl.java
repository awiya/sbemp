package com.example.employeerailway.service;

import com.example.employeerailway.dto.DepartmentDTO;
import com.example.employeerailway.model.Department;
import com.example.employeerailway.repository.DepartmentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

@Service
@Transactional
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepo departmentRepo;

    @Override
    public Department saveDepartment(DepartmentDTO departmentDTO) {
        Department department = fromDepartmentDTO(departmentDTO);
        return departmentRepo.save(department);
    }

    @Override
    public List<DepartmentDTO> getAllDepartments() {
        List<DepartmentDTO> departmentDTOS = departmentRepo.findAll().stream().map(department -> fromDepartment(department)).toList();
        return departmentDTOS;
    }

    @Override
    public DepartmentDTO getDepartmentById(Long id) {
        Department department = departmentRepo.findById(id).orElseThrow(() -> new RuntimeException("Department not found"));
        return fromDepartment(department);
    }

    @Override
    public Department updateDepartment(Department department, Long id) {
        Department existingDep = departmentRepo.findById(id).orElseThrow(() -> new RuntimeException("Department not found"));
        if (Objects.nonNull(department.getName()) && !"".equalsIgnoreCase(department.getName())){
            existingDep.setName(department.getName());
        }
        if (Objects.nonNull(department.getAddress()) && !"".equalsIgnoreCase(department.getAddress())){
            existingDep.setAddress(department.getAddress());
        }
        if (Objects.nonNull(department.getCode()) && !"".equalsIgnoreCase(department.getCode())){
            existingDep.setCode(department.getCode());
        }
        return departmentRepo.save(existingDep);
    }

    @Override
    public void deleteDepartment(Long id) {
        departmentRepo.deleteById(id);
    }

    @Override
    public DepartmentDTO findDepartmentById(String name) {
        Department department = departmentRepo.findByNameIgnoreCase(name);
        return fromDepartment(department);

    }

    @Override
    public List<DepartmentDTO> fetchDepartmentsByNameContains(String s) {
        List<Department> byNameContaining = departmentRepo.findByNameContaining(s);
        List<DepartmentDTO> departmentDTOS = byNameContaining.stream().map(department -> fromDepartment(department)).toList();
        return departmentDTOS;
    }

    private DepartmentDTO fromDepartment(Department department) {
        DepartmentDTO departmentDTO = DepartmentDTO.builder()
                .name(department.getName())
                .address(department.getAddress())
                .code(department.getCode())
                .build();
        return departmentDTO;
    }

    private Department fromDepartmentDTO(DepartmentDTO departmentDTO) {
        Department department = Department.builder()
                .name(departmentDTO.getName())
                .address(departmentDTO.getAddress())
                .code(departmentDTO.getCode())
                .build();
        return department;
    }
}
