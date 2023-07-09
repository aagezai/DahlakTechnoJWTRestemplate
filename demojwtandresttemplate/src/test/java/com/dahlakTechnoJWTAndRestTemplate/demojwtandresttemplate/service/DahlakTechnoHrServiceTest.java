package com.dahlakTechnoJWTAndRestTemplate.demojwtandresttemplate.service;


import com.dahlakTechnoJWTAndRestTemplate.demojwtandresttemplate.pojo.Employee;
import com.dahlakTechnoJWTAndRestTemplate.demojwtandresttemplate.pojo.Employee;
import jakarta.servlet.http.HttpServletRequest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class DahlakTechnoHrServiceTest {

    @InjectMocks
    private DahlakTechnoHrService dahlakTechnoHrService;

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private HttpServletRequest httpServletRequest;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetEmployeeOfCompany() throws Exception {
        String url = "http://localhost:8081/employee/getEmployees";
        List<Employee> expectedEmployeeList = Arrays.asList(new Employee(), new Employee());
        String jwtToken = "Bearer anyToken";
        ResponseEntity<List> restTemplateResp = new ResponseEntity<>(expectedEmployeeList, HttpStatus.OK);
        when(httpServletRequest.getHeader("Authorization")).thenReturn(jwtToken);
        when(restTemplate.exchange(eq(url), eq(HttpMethod.GET), any(HttpEntity.class), eq(List.class)))
                .thenReturn(restTemplateResp);
        List<Employee> actualEmployeeList = dahlakTechnoHrService.getEmployeeOfCompany(httpServletRequest);
        verify(restTemplate, times(1)).exchange(eq(url), eq(HttpMethod.GET), any(HttpEntity.class), eq(List.class));
        assertEquals(expectedEmployeeList, actualEmployeeList);
    }

    @Test(expected = RuntimeException.class)
    public void testGetEmployeeOfCompanyWithInvalidJwtToken() throws Exception {
        String jwtToken = "BeareranyToken";
        when(httpServletRequest.getHeader("Authorization")).thenReturn(jwtToken);
        dahlakTechnoHrService.getEmployeeOfCompany(httpServletRequest);
    }
}
