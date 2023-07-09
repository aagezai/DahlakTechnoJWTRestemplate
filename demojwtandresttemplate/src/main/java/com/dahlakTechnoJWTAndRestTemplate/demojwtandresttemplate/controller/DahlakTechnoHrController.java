package com.dahlakTechnoJWTAndRestTemplate.demojwtandresttemplate.controller;

import com.dahlakTechnoJWTAndRestTemplate.demojwtandresttemplate.pojo.Employee;
import com.dahlakTechnoJWTAndRestTemplate.demojwtandresttemplate.service.DahlakTechnoHrService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("dahlakTechnoHr")
public class DahlakTechnoHrController {
    @Autowired
    private DahlakTechnoHrService dahlakTechnoHrServie;
    @GetMapping("/getEmployeeOfCompany")
    public List<Employee> getEmployeeOfCompany(HttpServletRequest httpServletRequest) throws Exception {
        return dahlakTechnoHrServie.getEmployeeOfCompany(httpServletRequest);
    }

}
