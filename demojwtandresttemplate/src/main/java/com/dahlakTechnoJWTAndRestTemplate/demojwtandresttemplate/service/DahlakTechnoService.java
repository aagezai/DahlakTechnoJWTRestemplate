package com.dahlakTechnoJWTAndRestTemplate.demojwtandresttemplate.service;

import com.dahlakTechnoJWTAndRestTemplate.demojwtandresttemplate.model.DahlakTechnoCompany;
import com.dahlakTechnoJWTAndRestTemplate.demojwtandresttemplate.repository.DahlakTechnoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DahlakTechnoService {
    @Autowired
    private DahlakTechnoRepo dahlakTechnoRepo;

    public DahlakTechnoCompany saveDahlakTechno(DahlakTechnoCompany dahlakTechnoCompany) {
        return dahlakTechnoRepo.save(dahlakTechnoCompany);
    }


    public Optional<DahlakTechnoCompany> getDahlakTechnoCompById(Integer id) {
        return dahlakTechnoRepo.findById(id);
    }
}
