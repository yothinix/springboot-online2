package com.example.springbootonline2.service;

import com.example.springbootonline2.domain.Employee;
import com.example.springbootonline2.repository.EmployeeJPARepository;
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

    @Autowired private EmployeeRepository employeeRepository;

    @Autowired private EmployeeJPARepository jpaRepository;

    public List<Employee> listAll() {
        return jpaRepository.findAll();
    }

    public Employee findById(Integer id) {
        return jpaRepository.findById(id).orElseThrow(() -> new UnProcessableException("Not found employee."));
    }

    @Transactional
    public void save(Employee employee) {
        jpaRepository.save(employee);
    }

    @Transactional
    public void update(Integer id, Employee employee) {
        Employee employeeEntity = findById(id);
        employeeEntity.setFirstName(employee.getFirstName());
        employeeEntity.setLastName(employee.getLastName());

        jpaRepository.save(employeeEntity);
    }

    @Transactional
    public void delete(Integer id) {
        Employee employeeEntity = findById(id);
        jpaRepository.delete(employeeEntity);
    }

    public List<Employee> queryByLastName(String lastName) {
        return jpaRepository.findByLastName(lastName);
    }

    public List<Employee> queryByFirstName(String firstName) {
        return jpaRepository.listFirstName(firstName);
    }

    public List<EmployeeResponse> queryByNativeQuery() {
        return employeeRepository.queryByNativeQuery().stream().peek(it -> {
            it.setMoney(10);
        }).collect(Collectors.toList());
    }

}
