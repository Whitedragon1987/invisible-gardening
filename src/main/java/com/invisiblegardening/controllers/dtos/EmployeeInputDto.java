package com.invisiblegardening.controllers.dtos;

import com.invisiblegardening.Models.Employee;

public class EmployeeInputDto {
    public Long id;

    public String name;
    public String address;
    public String zipcode;
    public String city;
    public String emailaddress;
    public String phoneNumber;
    public String cityServiceNumber;
    public String ibanNumber;

    public Employee toEmployee() {
        var employee = new Employee();

        employee.setId(id);

        employee.setName(name);

        employee.setAddress(address);

        employee.setZipcode(zipcode);

        employee.setCity(city);

        employee.setEmailaddress(emailaddress);

        employee.setPhoneNumber(phoneNumber);

        employee.setCity(city);

        employee.setCityServiceNumber(cityServiceNumber);

        employee.setIbanNumber(ibanNumber);

        return employee;

    }

}
