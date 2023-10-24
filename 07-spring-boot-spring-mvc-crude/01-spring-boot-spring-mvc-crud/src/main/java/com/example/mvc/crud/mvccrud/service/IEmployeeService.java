package com.example.mvc.crud.mvccrud.service;

import com.example.mvc.crud.mvccrud.entity.Employee;

import java.util.List;

public interface IEmployeeService {

    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    Employee update(Employee employee);

    void delete(int id);
}
