package com.invisiblegardening.controllers.dtos;

import com.invisiblegardening.Models.Employee;

public class EmployeeDto {
    public Long id;

    public String name;
    public String address;
    public String zipcode;
    public String city;
    public String emailaddress;
    public String phoneNumber;
    public String cityServiceNumber;
    public String ibanNumber;


    public static EmployeeDto fromEmployee(Employee employee) {
        if (employee == null) return null;

        var dto = new EmployeeDto();

        dto.id = employee.getId();

        dto.name = employee.getName();

        dto.address = employee.getAddress();

        dto.zipcode = employee.getZipcode();

        dto.city = employee.getCity();

        dto.emailaddress = employee.getEmailaddress();

        dto.phoneNumber = employee.getPhoneNumber();

        dto.cityServiceNumber = employee.getCityServiceNumber();

        dto.ibanNumber = employee.getIbanNumber();

        return dto;

    }

}
