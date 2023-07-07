package com.dahlakTechnoJWTAndRestTemplate.demojwtandresttemplate.controller;

import com.dahlakTechnoJWTAndRestTemplate.demojwtandresttemplate.model.DahlakTechnoCompany;
import com.dahlakTechnoJWTAndRestTemplate.demojwtandresttemplate.pojo.DahlakTechnoHr;
import com.dahlakTechnoJWTAndRestTemplate.demojwtandresttemplate.service.DahlakTechnoHrService;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("dahlakTechnoHr")
public class DahlakTechnoHrController {
    @Autowired
    private DahlakTechnoHrService dahlakTechnoHrServie;
    @GetMapping("/getEmployeeOfCompany")
    public DahlakTechnoHr getEmployeeOfCompany(HttpServletRequest httpServletRequest) throws Exception {
        return dahlakTechnoHrServie.getEmployeeOfCompany(httpServletRequest);
    }

}
