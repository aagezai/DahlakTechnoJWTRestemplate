package com.dahlakTechnoJWTAndRestTemplate.demojwtandresttemplate.controller;

import com.dahlakTechnoJWTAndRestTemplate.demojwtandresttemplate.model.DahlakTechnoCompany;
import com.dahlakTechnoJWTAndRestTemplate.demojwtandresttemplate.service.DahlakTechnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/DahlakTechno")
public class DahlakTechnoController {
    @Autowired
    private DahlakTechnoService dahlakTechnoService;
    @PostMapping("/saveCompany")
    public DahlakTechnoCompany saveCompanyInfo(@RequestBody DahlakTechnoCompany dahlakTechnoCompany){
        return dahlakTechnoService.saveDahlakTechno(dahlakTechnoCompany);
    }
    @GetMapping("/getCompany/{id}")
    public ResponseEntity<DahlakTechnoCompany> getCompanyInfo(@RequestParam Integer id){
        Optional<DahlakTechnoCompany> dahlakTechnoCompany = dahlakTechnoService.getDahlakTechnoCompById(id);
        if(dahlakTechnoCompany.isPresent()){
            return new ResponseEntity<>(dahlakTechnoCompany.get(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
