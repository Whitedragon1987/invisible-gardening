package com.invisiblegardening.services;

import com.invisiblegardening.Models.Company;

public interface CompanyService {

    Company getCompany(Long id);
    Company getCompanyByUserDataId(Long userDataId);
    Company saveCompany(Company company);

    void deleteCompany(Long id);
    void updateCompany(Long id, Company company);

    void assignUserDataToCompany(Long id, Long userDataId);
}