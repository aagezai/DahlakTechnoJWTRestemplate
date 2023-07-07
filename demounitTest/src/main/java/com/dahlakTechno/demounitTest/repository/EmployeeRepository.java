package com.dahlakTechno.demounitTest.repository;

import com.dahlakTechno.demounitTest.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // You can define additional query methods here if needed
}
