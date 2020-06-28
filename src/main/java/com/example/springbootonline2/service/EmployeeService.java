package com.example.springbootonline2.service;

import com.example.springbootonline2.domain.Employee;
import com.example.springbootonline2.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> listAll() {
        return employeeRepository.listAll();
    }

    public Employee findById(Integer id) {
        return employeeRepository.findById(id);
    }

    public void save(Employee employee) {
        employeeRepository.save(employee);
    }
}
