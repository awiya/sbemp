package com.example.employeerailway.repository;

import com.example.employeerailway.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepo extends JpaRepository<Department,Long> {
    Department findByName(String name);
}
