package com.invisiblegardening.services;

import com.invisiblegardening.Exceptions.RecordNotFoundException;
import com.invisiblegardening.Models.Employee;
import com.invisiblegardening.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeRepository employeeRepository;


    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {

        this.employeeRepository = employeeRepository;

    }

    @Override
    public List<Employee> getEmployees() {

        return employeeRepository.findAll();

    }

    @Override
    public List<Employee> findEmployeesByName(String name) {

        return employeeRepository.findByNameContainingIgnoreCase(name);

    }

    @Override
    public Employee getEmployee(Long id) {

        Optional<Employee> employee = employeeRepository.findById(id);

        if(employee.isPresent()) {

            return employee.get();

        } else {

            throw new RecordNotFoundException("Machine does not exist");

        }

    }

    @Override
    public Employee saveEmployee(Employee employee) {

        return employeeRepository.save(employee);

    }

    @Override
    public void updateEmployee(Long id, Employee employee) {

        Optional<Employee> optionalEmployee = employeeRepository.findById(id);

        if (optionalEmployee.isPresent()) {

            var storedEmployee = optionalEmployee.get();
            storedEmployee.setId(storedEmployee.getId());
            storedEmployee.setName(employee.getName());
            storedEmployee.setCity(employee.getCity());
            storedEmployee.setAddress(employee.getAddress());
            storedEmployee.setEmailaddress(employee.getEmailaddress());
            storedEmployee.setCityServiceNumber(employee.getCityServiceNumber());
            storedEmployee.setIbanNumber(employee.getIbanNumber());
            storedEmployee.setPhoneNumber(employee.getPhoneNumber());
            storedEmployee.setZipcode(employee.getZipcode());
            employeeRepository.save(storedEmployee);

        } else {

            throw new RecordNotFoundException("employee does not exist");

        }

    }

    @Override
    public void deleteEmployee(Long id) {

        employeeRepository.deleteById(id);

    }

}
