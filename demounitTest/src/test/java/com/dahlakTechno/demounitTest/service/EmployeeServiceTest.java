package com.dahlakTechno.demounitTest.service;

import com.dahlakTechno.demounitTest.model.Employee;
import com.dahlakTechno.demounitTest.repository.EmployeeRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.junit.Before;
import org.junit.Test;
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
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.Silent.class)
public class EmployeeServiceTest {
    @InjectMocks
    private EmployeeService employeeService;
    @Mock
    private EmployeeRepository employeeRepository;
    @Mock
    private HttpServletRequest httpServletRequest;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getAllEmployees() {
        List<Employee> employees = List.of(
                new Employee(1, "John", 123456),
                new Employee(2, "Jane", 789012)
        );
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOm51bGwsImF1ZCI6ImF1ZGllbmNlIiwicHJpdmF0ZSI6eyJjdXN0b21Qcml2YXRlQ2xhaW0iOiJwcml2YXRlVmFsdWUiLCJyb2xlIjpudWxsfSwicHVibGljIjp7ImNvbXBhbnlOYW1lIjpudWxsLCJlbWFpbElkIjpudWxsLCJjdXN0b21QdWJsaWNDbGFpbSI6InB1YmxpY1ZhbHVlIn0sImlzcyI6Imlzc3VlciIsImlhdCI6MTY4ODU1MzgwNX0=.lAy/bq54d8d+VBH4s8TjL9RI6AathbFkEIymKA0zJ/A=";
        //httpServletRequest.setHeader("Authorization", "Bearer " + token);
        Mockito.when(employeeRepository.findAll()).thenReturn(employees);

        List<Employee> result = employeeService.getAllEmployees(httpServletRequest);

        assertEquals(2, result.size());
        assertEquals(1, result.get(0).getId());
        assertEquals("John", result.get(0).getName());
        assertEquals(123456, result.get(0).getSsn());
        assertEquals(2, result.get(1).getId());
        assertEquals("Jane", result.get(1).getName());
        assertEquals(789012, result.get(1).getSsn());
        assertEquals(employees.get(1),result.get(1));

        verify(employeeRepository, times(1)).findAll();
    }

    @Test
    public void createEmployee() {
        Employee employee = new Employee(1, "John", 123456);

        Mockito.when(employeeRepository.save(employee)).thenReturn(employee);

        Employee result = employeeService.createEmployee(employee);

        assertNotNull(result);
        assertEquals(1, result.getId());
        assertEquals("John", result.getName());
        assertEquals(123456, result.getSsn());

        Mockito.verify(employeeRepository, Mockito.times(1)).save(employee);
    }
}