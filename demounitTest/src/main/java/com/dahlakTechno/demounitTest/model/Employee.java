package com.dahlakTechno.demounitTest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee {
    @Id
    private Integer id;
    private String name;
    private Integer ssn;

    public Employee(Integer id, String name, Integer ssn) {
        this.id = id;
        this.name = name;
        this.ssn = ssn;
    }

    public Employee() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSsn() {
        return ssn;
    }

    public void setSsn(Integer ssn) {
        this.ssn = ssn;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ssn=" + ssn +
                '}';
    }
}
