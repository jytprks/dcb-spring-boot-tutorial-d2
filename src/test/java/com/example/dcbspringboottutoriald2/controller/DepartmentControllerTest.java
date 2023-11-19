package com.example.dcbspringboottutoriald2.controller;

import com.example.dcbspringboottutoriald2.entity.Department;
import com.example.dcbspringboottutoriald2.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department department;
    @BeforeEach
    void setUp(){
        department = Department.builder()
                .address("Ahemdabad").name("IT").id(1L).code("IT-01").build();
    }
    @Test
    void saveDepartment() throws Exception {
        Department inputDepartment = Department.builder()
                .address("Ahemdabad").name("IT").code("IT-01").build();
        Mockito.when(departmentService.saveDepartment(inputDepartment)).thenReturn(department);
        mockMvc.perform(MockMvcRequestBuilders.post("/departments")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                "   \"name\":\"IT\",\n" +
                "    \"address\": \"Ahemdabad\",\n" +
                "    \"code\":\"IT-01\"\n" +
                "}")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void getDepartmentById() {
    }
}