package com.example.springbootonline2.controller;

import com.example.springbootonline2.domain.Employee;
import com.example.springbootonline2.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> listAllEmployee() {
        return employeeService.listAll();
    }

    @GetMapping("/query")
    public List<Employee> findByLastName(@RequestParam String lastName) {
        return employeeService.queryByLastName(lastName);
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Integer id) {
        return employeeService.findById(id);
    }

    @PostMapping
    public void createEmployee(@RequestBody Employee employee) {
        employeeService.save(employee);
    }

    @PutMapping("/{id}")
    public void updateEmployee(@PathVariable Integer id, @RequestBody Employee employee) {
        employeeService.update(id, employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Integer id) {
        employeeService.delete(id);
    }
}
