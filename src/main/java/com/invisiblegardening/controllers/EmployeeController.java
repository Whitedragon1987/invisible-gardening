package com.invisiblegardening.controllers;

import com.invisiblegardening.Models.Employee;
import com.invisiblegardening.controllers.dtos.EmployeeDto;
import com.invisiblegardening.controllers.dtos.EmployeeInputDto;
import com.invisiblegardening.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {this.employeeService = employeeService;}

    @GetMapping
    public List<EmployeeDto> getEmployees(@RequestParam(value = "name", required = false, defaultValue = "") String name) {

        var dtos = new ArrayList<EmployeeDto>();

        List<Employee> employeeList;

        if (name == null) {

            employeeList = employeeService.getEmployees();

        } else {

            employeeList = employeeService.findEmployeesByName(name);

        }

        for (Employee employee : employeeList) {

            dtos.add(EmployeeDto.fromEmployee(employee));

        }

        return dtos;

    }

    @GetMapping("/{id}")
    public EmployeeDto getEmployee(@PathVariable("id") Long id) {

        var employee = employeeService.getEmployee(id);

        return EmployeeDto.fromEmployee(employee);

    }

    @PostMapping
    public EmployeeDto saveEmployee(@RequestBody EmployeeInputDto dto) {

        var employee = employeeService.saveEmployee(dto.toEmployee());

        return EmployeeDto.fromEmployee(employee);

    }

    @PutMapping("/{id}")
    public EmployeeDto updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {

        employeeService.updateEmployee(id, employee);

        return EmployeeDto.fromEmployee(employee);

    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable("id") Long id) {

        employeeService.deleteEmployee(id);

    }

}
