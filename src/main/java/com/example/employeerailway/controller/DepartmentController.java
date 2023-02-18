package com.example.employeerailway.controller;

import com.example.employeerailway.dto.DepartmentDTO;
import com.example.employeerailway.model.Department;
import com.example.employeerailway.model.Employee;
import com.example.employeerailway.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;

    @PostMapping
    public Department saveDepartment(DepartmentDTO departmentDTO){
        return departmentService.saveDepartment(departmentDTO);
    }

    @GetMapping("/all")
    public List<DepartmentDTO> getAllDepartments(){
        return departmentService.getAllDepartments();
    }

    @GetMapping("/{id}")
    public DepartmentDTO getDepartmentById(@PathVariable Long id){
        return departmentService.getDepartmentById(id);
    }

    @PutMapping("/update/{id}")
    public Department updateDepartment(@RequestBody Department department , @PathVariable Long id){
        return departmentService.updateDepartment(department,id);
    }

    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable Long id){
        departmentService.deleteDepartment((id));
    }

    @GetMapping("/name/{name}")
    public DepartmentDTO findDepartmentById(@PathVariable String name){
        return departmentService.findDepartmentById(name);
    }

    @GetMapping("/contains/{s}")
    public List<DepartmentDTO> fetchDepartmentsByNameContains(@PathVariable String s){
        return departmentService.fetchDepartmentsByNameContains(s);
    }

}
