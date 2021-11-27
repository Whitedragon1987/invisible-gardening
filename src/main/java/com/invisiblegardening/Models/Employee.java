package com.invisiblegardening.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Employee {

    @Id
    @GeneratedValue
    Long id;

    String name;
    String address;
    String zipcode;
    String city;
    String emailaddress;
    String phoneNumber;
    String cityServiceNumber;
    String ibanNumber;

    @OneToMany(mappedBy = "employee")
    @JsonBackReference("jobEmployee")
    List<Job> joblist;

    public Long getId() {

        return id;

    }

    public String getAddress() {

        return address;

    }

    public String getZipcode() {

        return zipcode;

    }

    public String getCity() {

        return city;

    }

    public String getEmailaddress() {

        return emailaddress;

    }

    public String getPhoneNumber() {

        return phoneNumber;

    }

    public String getCityServiceNumber() {

        return cityServiceNumber;

    }

    public String getIbanNumber() {

        return ibanNumber;

    }

    public String getName() {

        return name;

    }

    public void setId(Long id) {

        this.id = id;

    }

    public void setAddress(String employeesAddress) {

        this.address = employeesAddress;

    }

    public void setZipcode(String employeesZipcode) {

        this.zipcode = employeesZipcode;

    }

    public void setCity(String employeesCity) {

        this.city = employeesCity;

    }

    public void setEmailaddress(String employeesEmailaddress) {

        this.emailaddress = employeesEmailaddress;

    }

    public void setPhoneNumber(String employeesPhoneNumber) {

        this.phoneNumber = employeesPhoneNumber;

    }

    public void setCityServiceNumber(String employeesCityServiceNumber) {

        this.cityServiceNumber = employeesCityServiceNumber;

    }

    public void setIbanNumber(String employeesIbanNumber) {

        this.ibanNumber = employeesIbanNumber;

    }

    public void setName(String employeesName) {

        this.name = employeesName;

    }



}

