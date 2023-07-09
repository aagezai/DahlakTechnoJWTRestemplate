package com.dahlakTechnoJWTAndRestTemplate.demojwtandresttemplate.service;

import com.dahlakTechnoJWTAndRestTemplate.demojwtandresttemplate.pojo.Employee;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class DahlakTechnoHrService {
    @Autowired
    private RestTemplate restTemplate;

    public List<Employee> getEmployeeOfCompany(HttpServletRequest httpServletRequest) throws Exception {
        String url = "http://localhost:8081/employee/getEmployees";
        List<Employee> employeeList = restTemplate.
                exchange(url, HttpMethod.GET, getHttpEntity(httpServletRequest), List.class)
                .getBody();
        return employeeList;
    }

    private HttpEntity getHttpEntity(HttpServletRequest httpServletRequest) throws Exception {
        String jwtToken = httpServletRequest.getHeader("Authorization");
        if (!StringUtils.hasText(jwtToken) || !jwtToken.startsWith("Bearer ")) {
            throw new RuntimeException("not valid jwtToken");
        }
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization", jwtToken);
        HttpEntity httpEntity = new HttpEntity(httpHeaders);
        return httpEntity;
    }

}