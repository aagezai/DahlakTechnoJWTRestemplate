package com.dahlakTechno.demounitTest.controller;

import com.dahlakTechno.demounitTest.model.Employee;
import com.dahlakTechno.demounitTest.service.EmployeeService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/getEmployees")
    public List<Employee> getAllEmployees(HttpServletRequest httpServletRequest) {
        return employeeService.getAllEmployees(httpServletRequest);
    }

    @PostMapping("/saveEmployees")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }
}
