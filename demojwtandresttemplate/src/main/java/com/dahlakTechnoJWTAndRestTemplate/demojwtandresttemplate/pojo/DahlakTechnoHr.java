package com.dahlakTechnoJWTAndRestTemplate.demojwtandresttemplate.pojo;

import com.dahlakTechnoJWTAndRestTemplate.demojwtandresttemplate.model.DahlakTechnoCompany;
import lombok.*;

import java.util.List;
public class DahlakTechnoHr {
    private DahlakTechnoCompany dahlakTechnoCompany;
    private List<Employee> employeeList;

    public DahlakTechnoHr(DahlakTechnoCompany dahlakTechnoCompany, List<Employee> employeeList) {
        this.dahlakTechnoCompany = dahlakTechnoCompany;
        this.employeeList = employeeList;
    }

    public DahlakTechnoHr() {
    }


    public DahlakTechnoCompany getDahlakTechnoCompany() {
        return dahlakTechnoCompany;
    }

    public void setDahlakTechnoCompany(DahlakTechnoCompany dahlakTechnoCompany) {
        this.dahlakTechnoCompany = dahlakTechnoCompany;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @Override
    public String toString() {
        return "DahlakTechnoHr{" +
                "dahlakTechnoCompany=" + dahlakTechnoCompany +
                ", employeeList=" + employeeList +
                '}';
    }
}
