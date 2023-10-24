package com.example.mvc.crud.mvccrud.dao;

import com.example.mvc.crud.mvccrud.entity.Employee;
import java.util.List;

public interface IEmployeeDao{

    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    void deleteById(int id);

}
