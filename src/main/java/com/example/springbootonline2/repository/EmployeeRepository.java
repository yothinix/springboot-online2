package com.example.springbootonline2.repository;

import com.example.springbootonline2.domain.Employee;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class EmployeeRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(Employee employee) {
        entityManager.persist(employee);
    }

    public List<Employee> listAll() {
        return entityManager.createQuery("from Employee")
                .getResultList();
    }

    public Employee findById(Integer id) {
        return entityManager.find(Employee.class, id);
    }

    @Transactional
    public void delete(Employee employeeEntity) {
        entityManager.remove(employeeEntity);
    }
}
