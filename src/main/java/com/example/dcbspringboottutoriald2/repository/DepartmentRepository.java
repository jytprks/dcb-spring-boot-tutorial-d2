package com.example.dcbspringboottutoriald2.repository;

import com.example.dcbspringboottutoriald2.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Department findByNameIgnoreCase(String Name);
}
