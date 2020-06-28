package com.example.springbootonline2.repository;

import com.example.springbootonline2.domain.Employee;
import com.example.springbootonline2.response.EmployeeResponse;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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

    public List<Employee> findByLastName(String lastName) {
        Query query = entityManager.createQuery("from Employee where lastName = :LAST_NAME");
        query.setParameter("LAST_NAME", lastName);
        return query.getResultList();
    }

    public List<EmployeeResponse> queryByNativeQuery() {
        Query query = entityManager
                .createNativeQuery("select e.id, e.first_name, e.last_name, " +
                        "'IT' as department from EMPLOYEE e", EmployeeResponse.class);
        return query.getResultList();
    }
}
