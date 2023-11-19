package com.example.dcbspringboottutoriald2.repository;

import com.example.dcbspringboottutoriald2.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager testEntityManager;
    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .name("Test")
                .address("Test address")
                .code("TS-01").build();
        testEntityManager.persist(department);
    }

    @Test
    @DisplayName("When find by id called for department repository return department")
    public void whenFindByIdCalledThenReturnDepartment(){
        Department department = departmentRepository.findById(1L).get();
        assertEquals(department.getName(), "Test");
    }
}