package com.example.dcbspringboottutoriald2.service;

import com.example.dcbspringboottutoriald2.entity.Department;
import com.example.dcbspringboottutoriald2.error.NotFoundException;
import com.example.dcbspringboottutoriald2.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(long id) throws NotFoundException {
        Optional<Department> department = departmentRepository.findById(id);

        if (!department.isPresent()){
            throw new NotFoundException("Department not found");
        }

        return department.get();
    }

    @Override
    public long deleteDepartmentById(long id) {
         departmentRepository.deleteById(id);
         return id;
    }

    @Override
    public Department updateDepartment(long id, Department department) {
        Department dbDepartment = departmentRepository.findById(id).get();

        if (department.getName() != null && !department.getName().equals("")){
            dbDepartment.setName(department.getName());
        }

        if (department.getAddress() != null && !department.getAddress().equals("")){
            dbDepartment.setAddress(department.getAddress());
        }

        if (department.getCode() != null && !department.getCode().equals("")){
            dbDepartment.setCode(department.getCode());
        }

        return departmentRepository.save(dbDepartment);
    }

    @Override
    public Department getDepartmentByName(String name) {
        return departmentRepository.findByNameIgnoreCase(name);
    }
}
