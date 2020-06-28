package com.example.springbootonline2.service;

import com.example.springbootonline2.domain.Employee;
import com.example.springbootonline2.response.EmployeeResponse;
import com.example.springbootonline2.exception.UnProcessableException;
import com.example.springbootonline2.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> listAll() {
        return employeeRepository.listAll();
    }

    public Employee findById(Integer id) {
        Employee employeeEntity = employeeRepository.findById(id);
        if (employeeEntity == null) {
            throw new UnProcessableException("Data not found id: " + id);
        }
        return employeeEntity;
    }

    @Transactional
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Transactional
    public void update(Integer id, Employee employee) {
        Employee employeeEntity = findById(id);
        employeeEntity.setFirstName(employee.getFirstName());
        employeeEntity.setLastName(employee.getLastName());

        employeeRepository.save(employeeEntity);
    }

    @Transactional
    public void delete(Integer id) {
        Employee employeeEntity = findById(id);
        employeeRepository.delete(employeeEntity);
    }

    public List<Employee> queryByLastName(String lastName) {
        return employeeRepository.findByLastName(lastName);
    }

    public List<EmployeeResponse> queryByNativeQuery() {
        return employeeRepository.queryByNativeQuery().stream().peek(it -> {
            it.setMoney(10);
        }).collect(Collectors.toList());
    }

}
