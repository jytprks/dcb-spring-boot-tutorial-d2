package com.example.dcbspringboottutoriald2.controller;

import com.example.dcbspringboottutoriald2.entity.Department;
import com.example.dcbspringboottutoriald2.error.NotFoundException;
import com.example.dcbspringboottutoriald2.service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping
    public Department saveDepartment(@Valid @RequestBody Department department) {
        LOGGER.info("Inside save department");
        return departmentService.saveDepartment(department);
    }

    @GetMapping
    public List<Department> getAllDepartment(){
        return departmentService.getAll();
    }

    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable(value = "id") long id) throws NotFoundException {
        return departmentService.getDepartmentById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteDepartmentById(@PathVariable(value = "id") long id){
        long deleteDepartmentById = departmentService.deleteDepartmentById(id);
        return "department is deleted - " + deleteDepartmentById;
    }

    @PutMapping("/{id}")
    public Department updateDepartment(@PathVariable(value = "id") long id, @RequestBody Department department){
        return departmentService.updateDepartment(id, department);
    }

    @GetMapping(params = "name")
    public Department findDepartmentByName(@RequestParam String name){
        return departmentService.getDepartmentByName(name);
    }
}
