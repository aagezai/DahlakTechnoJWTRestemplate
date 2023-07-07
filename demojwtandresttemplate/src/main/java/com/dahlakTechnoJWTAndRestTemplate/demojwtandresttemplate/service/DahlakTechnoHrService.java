package com.dahlakTechnoJWTAndRestTemplate.demojwtandresttemplate.service;
import com.dahlakTechnoJWTAndRestTemplate.demojwtandresttemplate.model.DahlakTechnoCompany;
import com.dahlakTechnoJWTAndRestTemplate.demojwtandresttemplate.pojo.DahlakTechnoHr;
import com.dahlakTechnoJWTAndRestTemplate.demojwtandresttemplate.pojo.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.*;

@Service
public class DahlakTechnoHrService {
    @Autowired
    private RestTemplate restTemplate;

    public DahlakTechnoHr getEmployeeOfCompany(HttpServletRequest httpServletRequest) throws Exception {
        String url = "http://localhost:8081/employee/getEmployees";
      List<Employee> employeeList = restTemplate.exchange(url, HttpMethod.GET,getHttpEntity(httpServletRequest),List.class).getBody();
        DahlakTechnoHr dahlakTechnoHr = new DahlakTechnoHr();
       dahlakTechnoHr.setEmployeeList(employeeList);
        return dahlakTechnoHr;
    }

    private HttpEntity getHttpEntity(HttpServletRequest httpServletRequest) throws Exception {
        HttpHeaders httpHeaders = createHttpHeaders(httpServletRequest);
        HttpEntity httpEntity = new HttpEntity(httpHeaders);
        return httpEntity;
    }

    private HttpHeaders createHttpHeaders(HttpServletRequest httpServletRequest) throws Exception {
        HttpHeaders httpHeaders = new HttpHeaders();
        String jwtToken = extractTokenFromRequest(httpServletRequest);
        if (jwtToken == null)
            throw new RuntimeException("not valid token issue");
        httpHeaders.set("Authorization", jwtToken);
        return httpHeaders;
    }
    public String extractTokenFromRequest(HttpServletRequest request) {
        String authorizationHeader = request.getHeader("Authorization");
        if (StringUtils.hasText(authorizationHeader) && authorizationHeader.startsWith("Bearer ")) {
            return authorizationHeader; // Remove "Bearer " prefix
        }
        return null; // No valid token found
    }
}