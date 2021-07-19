package com.invisiblegardening.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Company {

    @Id
    @GeneratedValue
    Long id;

    String companyName;
    String companyAddress;
    String companyZipcode;
    String companyCity;
    String companyEmailaddress;
    String companyPhoneNumber;

    @OneToOne(mappedBy = "company")
    @JsonBackReference("userDataCompany")
    UserData userData;

    public Long getId() {

        return id;

    }

    public String getCompanyName() {

        return companyName;

    }

    public String getCompanyAddress() {

        return companyAddress;

    }

    public String getCompanyZipcode() {

        return companyZipcode;

    }

    public String getCompanyCity() {

        return companyCity;

    }

    public String getCompanyEmailaddress() {

        return companyEmailaddress;

    }

    public String getCompanyPhoneNumber() {

        return companyPhoneNumber;

    }

    public UserData getUserData() {

        return userData;

    }

    public void setId(Long id) {

        this.id = id;

    }

    public void setCompanyName(String companyName) {

        this.companyName = companyName;

    }

    public void setCompanyAddress(String companyAddress) {

        this.companyAddress = companyAddress;

    }

    public void setCompanyZipcode(String companyZipcode) {

        this.companyZipcode = companyZipcode;

    }

    public void setCompanyCity(String companyCity) {

        this.companyCity = companyCity;

    }

    public void setCompanyEmailaddress(String companyEmailaddress) {

        this.companyEmailaddress = companyEmailaddress;

    }

    public void setCompanyPhoneNumber(String companyPhoneNumber) {

        this.companyPhoneNumber = companyPhoneNumber;

    }

    public void setUserData(UserData userData) {

        this.userData = userData;

    }

}