package com.dahlakTechno.demounitTest.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {
    private Employee employee;

    @BeforeEach
    void setUp() {
        employee = new Employee();
    }

    @Test
    void getId() {
        employee.setId(12);
        assertEquals(12,employee.getId());
    }

    @Test
    void getName() {
        employee.setName("jhon");
        assertEquals("jhon",employee.getName());
    }

    @Test
    void getSsn() {
    }
}