package com.invisiblegardening.services;

import com.invisiblegardening.Models.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getEmployees();
    List<Employee> findEmployeesByName(String name);

    Employee getEmployee(Long id);
    Employee saveEmployee(Employee employee);

    void deleteEmployee(Long id);
    void updateEmployee(Long id, Employee employee);

}
