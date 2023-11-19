package com.example.dcbspringboottutoriald2.service;

import com.example.dcbspringboottutoriald2.entity.Department;
import com.example.dcbspringboottutoriald2.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp(){
        Department department = Department.builder()
                .name("IT")
                .address("Ahemdabad")
                .code("IT-01")
                .id(1L)
                .build();
        Mockito.when(departmentRepository.findByNameIgnoreCase("IT")).thenReturn(department);
    }

    @Test
    @DisplayName("Get department based on a valid department name")
    public void whenValidDepartmentNameThenDepartmentShouldFound(){
        String departmentName = "IT";
        Department found = departmentService.getDepartmentByName(departmentName);
        assertEquals(departmentName, found.getName());
    }
}