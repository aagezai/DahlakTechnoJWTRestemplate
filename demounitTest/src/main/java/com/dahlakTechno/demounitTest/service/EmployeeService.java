package com.dahlakTechno.demounitTest.service;

import com.dahlakTechno.demounitTest.util.ValidateTheToken;
import com.dahlakTechno.demounitTest.model.Employee;
import com.dahlakTechno.demounitTest.repository.EmployeeRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.logging.Logger;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    private static final Logger logger = Logger.getLogger(ValidateTheToken.class.getName());

    public List<Employee> getAllEmployees(HttpServletRequest httpServletRequest) {
        logger.info("get token from request");
        String token = extractTokenFromRequest(httpServletRequest);
        ValidateTheToken validateToken = new ValidateTheToken();
        logger.info("check validation token");
        if(validateToken.isValidateToken(token)) {
            System.out.println("validToken");
            return employeeRepository.findAll();
        }
        else {
            throw new RuntimeException("not valid token");
        }
    }
    public String extractTokenFromRequest(HttpServletRequest request) {
        String authorizationHeader = request.getHeader("Authorization");
        if (StringUtils.hasText(authorizationHeader) && authorizationHeader.startsWith("Bearer ")) {
            return authorizationHeader;
        }
        return null; // No valid token found
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
}
