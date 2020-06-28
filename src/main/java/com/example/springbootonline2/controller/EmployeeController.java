package com.example.springbootonline2.controller;

import com.example.springbootonline2.domain.Employee;
import com.example.springbootonline2.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Employee> listAllEmployee() {
        return employeeRepository.listAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Employee getEmployee(@PathVariable Integer id) {
        return employeeRepository.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void createEmployee(@RequestBody Employee employee) {
        employeeRepository.save(employee);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void updateEmployee(@PathVariable Integer id, @RequestBody Employee employee) {
    }
}
