package com.dahlakTechno.demounitTest.service;

import com.dahlakTechno.demounitTest.model.Employee;
import com.dahlakTechno.demounitTest.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {

        return employeeRepository.findAll();
    }

    public Employee createEmployee(Employee employee) {

        return employeeRepository.save(employee);
    }
}
