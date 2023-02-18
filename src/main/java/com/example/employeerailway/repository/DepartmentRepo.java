package com.example.employeerailway.repository;

import com.example.employeerailway.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepo extends JpaRepository<Department,Long> {
    Department findByNameIgnoreCase(String name);
    @Query("SELECT d FROM Department d WHERE d.name LIKE %:s%")
    List<Department> findByNameContaining(@Param("s") String s);

}
