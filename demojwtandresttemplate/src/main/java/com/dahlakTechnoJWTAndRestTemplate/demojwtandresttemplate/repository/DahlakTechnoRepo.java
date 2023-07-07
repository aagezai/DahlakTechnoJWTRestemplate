package com.dahlakTechnoJWTAndRestTemplate.demojwtandresttemplate.repository;

import com.dahlakTechnoJWTAndRestTemplate.demojwtandresttemplate.model.DahlakTechnoCompany;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DahlakTechnoRepo extends JpaRepository<DahlakTechnoCompany,Integer> {
}
