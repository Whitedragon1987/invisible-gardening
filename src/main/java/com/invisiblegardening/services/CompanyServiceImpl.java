package com.invisiblegardening.services;

import com.invisiblegardening.Exceptions.RecordNotFoundException;
import com.invisiblegardening.Models.Company;
import com.invisiblegardening.repositories.CompanyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {
    private CompanyRepository repository;

    @Autowired
    public CompanyServiceImpl(CompanyRepository repository) {

        this.repository = repository;

    }

    @Override
    public Company getCompany(Long id) {

        Optional<Company> company = repository.findById(id);

        if(company.isPresent()) {

            return company.get();

        } else {

            throw new RecordNotFoundException("Company does not exist");

        }

    }

    @Override
    public Company saveCompany(Company company) {

        return repository.save(company);

    }

    @Override
    public void deleteCompany(Long id) {

        repository.deleteById(id);

    }

    @Override
    public void updateCompany(Long id, Company company) {

        Optional<Company> optionalCompany = repository.findById(id);

        if (optionalCompany.isPresent()) {

            repository.deleteById(id);

            repository.save(company);

        } else {

            throw new RecordNotFoundException("company does not exist");

        }

    }

}
