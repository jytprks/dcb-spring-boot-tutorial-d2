package com.example.dcbspringboottutoriald2.service;

import com.example.dcbspringboottutoriald2.entity.Department;
import com.example.dcbspringboottutoriald2.error.NotFoundException;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);

    List<Department> getAll();

    Department getDepartmentById(long id) throws NotFoundException;

    long deleteDepartmentById(long id);

    Department updateDepartment(long id, Department department);

    Department getDepartmentByName(String name);
}
