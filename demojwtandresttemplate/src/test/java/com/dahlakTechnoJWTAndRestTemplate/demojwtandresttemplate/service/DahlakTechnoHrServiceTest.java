package com.dahlakTechnoJWTAndRestTemplate.demojwtandresttemplate.service;

import com.dahlakTechnoJWTAndRestTemplate.demojwtandresttemplate.pojo.Employee;
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
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.Silent.class)
public class DahlakTechnoHrServiceTest {
    @InjectMocks
    private DahlakTechnoHrService dahlakTechnoHrService;
    @Mock
    private RestTemplate restTemplate;
    @Mock
    private HttpServletRequest httpServletRequest;
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getEmployeeOfCompany() throws Exception {
        List<Employee> expected = new ArrayList<>();
        Employee employee = new Employee(1,"em",12);
        expected.add(employee);
        ResponseEntity<List> expectedREntity = new ResponseEntity<>(expected, HttpStatus.OK);
        //Mock1
        Mockito.when(httpServletRequest.getHeader("Authorization")).thenReturn("Bearer anyToken");
        //Mock
        Mockito.when(restTemplate.exchange(anyString(),eq(HttpMethod.GET),
                        any(HttpEntity.class),eq(List.class)))
                .thenReturn(expectedREntity);
        List<Employee> entityActual = dahlakTechnoHrService.getEmployeeOfCompany(httpServletRequest);
        //assert
        assertEquals(expected.get(0),entityActual.get(0));

    }
    @Test(expected = RuntimeException.class)
    public void getEmployeeOfCompanyIfTokenHasNoTextOrNoBearer() throws Exception {
        List<Employee> expected = new ArrayList<>();
        Employee employee = new Employee(1,"em",12);
        expected.add(employee);
        ResponseEntity<List> expectedREntity = new ResponseEntity<>(expected, HttpStatus.OK);
        //Mock1
        Mockito.when(httpServletRequest.getHeader("Authorization")).thenReturn(" anyToken");
        //Mock
        Mockito.when(restTemplate.exchange(anyString(),eq(HttpMethod.GET),
                        any(HttpEntity.class),eq(List.class)))
                .thenReturn(expectedREntity);
        List<Employee> entityActual = dahlakTechnoHrService.getEmployeeOfCompany(httpServletRequest);


    }
}
