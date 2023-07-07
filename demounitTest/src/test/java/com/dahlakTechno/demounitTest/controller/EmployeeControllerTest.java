package com.dahlakTechno.demounitTest.controller;

import com.dahlakTechno.demounitTest.model.Employee;
import com.dahlakTechno.demounitTest.service.EmployeeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.Silent.class)
public class EmployeeControllerTest {

    @InjectMocks
    private EmployeeController employeeController;

    @Mock
    private EmployeeService employeeService;

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllEmployees() {
        List<Employee> employees = List.of(
                new Employee(1, "John", 123456),
                new Employee(2, "Jane", 789012)
        );

        Mockito.when(employeeService.getAllEmployees()).thenReturn(employees);

        List<Employee> result = employeeController.getAllEmployees();

        assertEquals(2, result.size());
        assertEquals(1, result.get(0).getId());
        assertEquals("John", result.get(0).getName());
        assertEquals(123456, result.get(0).getSsn());
        assertEquals(2, result.get(1).getId());
        assertEquals("Jane", result.get(1).getName());
        assertEquals(789012, result.get(1).getSsn());
        assertEquals(employees.get(1),result.get(1));

        verify(employeeService, times(1)).getAllEmployees();
    }

    @Test
    public void testCreateEmployee() {
        Employee employee = new Employee(1, "John", 123456);

        Mockito.when(employeeService.createEmployee(employee)).thenReturn(employee);

        Employee result = employeeController.createEmployee(employee);

        assertNotNull(result);
        assertEquals(1, result.getId());
        assertEquals("John", result.getName());
        assertEquals(123456, result.getSsn());

        Mockito.verify(employeeService, Mockito.times(1)).createEmployee(any(Employee.class));
    }
}
