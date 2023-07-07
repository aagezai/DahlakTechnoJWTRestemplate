package com.dahlakTechnoJWTAndRestTemplate.demojwtandresttemplate.model;

import com.dahlakTechnoJWTAndRestTemplate.demojwtandresttemplate.pojo.Employee;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
public class DahlakTechnoCompany {
    @Id
    private Integer id;
    private String companyName;
    private String role;

    public DahlakTechnoCompany(Integer id, String companyName) {
        this.id = id;
        this.companyName = companyName;
    }

    public DahlakTechnoCompany() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "DahlakTechnoCompany{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
