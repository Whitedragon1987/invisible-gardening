package com.invisiblegardening.controllers;

import com.invisiblegardening.Models.Company;
import com.invisiblegardening.controllers.dtos.CompanyDto;
import com.invisiblegardening.controllers.dtos.CompanyInputDto;
import com.invisiblegardening.services.CompanyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("company")
public class CompanyController {
    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {

        this.companyService = companyService;

    }


    @GetMapping("/{id}")
    public CompanyDto getCompany(@PathVariable("id") Long id) {

        var company = companyService.getCompany(id);

        return CompanyDto.fromCompany(company);

    }

    @PostMapping
    public CompanyDto saveCompany(@RequestBody CompanyInputDto dto) {

        var company = companyService.saveCompany(dto.toCompany());

        return CompanyDto.fromCompany(company);

    }

    @PutMapping("/{id}")
    public CompanyDto updateCompany(@PathVariable Long id, @RequestBody Company company) {

        companyService.updateCompany(id, company);

        return CompanyDto.fromCompany(company);

    }

    @DeleteMapping("/{id}")
    public void deleteCompany(@PathVariable("id") Long id) {

        companyService.deleteCompany(id);

    }

}