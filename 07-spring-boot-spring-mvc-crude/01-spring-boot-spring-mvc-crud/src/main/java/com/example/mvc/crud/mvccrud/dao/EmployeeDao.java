package com.example.mvc.crud.mvccrud.dao;

import com.example.mvc.crud.mvccrud.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDao implements IEmployeeDao {

    private final EntityManager entityManager;

    @Autowired
    public EmployeeDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query = this.entityManager.createQuery("from Employee order by LastName", Employee.class);
        return query.getResultList();
    }

    @Override
    public Employee findById(int id) {
        return this.entityManager.find(Employee.class, id);
    }

    @Override
    public Employee save(Employee employee) {
        return this.entityManager.merge(employee);
    }

    @Override
    public void deleteById(int id) {
        this.entityManager.remove(this.entityManager.find(Employee.class, id));
    }
}
