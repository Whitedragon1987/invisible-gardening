package com.invisiblegardening.controllers.dtos;

import com.invisiblegardening.Models.Company;

public class CompanyDto {
    public Long id;
    public String name;
    public String address;
    public String zipcode;
    public String city;
    public String emailaddress;
    public String phoneNumber;


    public static CompanyDto fromCompany(Company company) {
        var dto = new CompanyDto();

        dto.id = company.getId();

        dto.name = company.getCompanyName();

        dto.address = company.getCompanyAddress();

        dto.zipcode = company.getCompanyZipcode();

        dto.city = company.getCompanyCity();

        dto.emailaddress = company.getCompanyEmailaddress();

        dto.phoneNumber = company.getCompanyPhoneNumber();

        return dto;

    }

}