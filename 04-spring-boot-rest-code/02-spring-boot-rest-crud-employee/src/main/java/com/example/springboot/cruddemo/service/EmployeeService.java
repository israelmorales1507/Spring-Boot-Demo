package com.example.springboot.cruddemo.service;

import com.example.springboot.cruddemo.dao.IEmployeeDao;
import com.example.springboot.cruddemo.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {

    private IEmployeeDao employeeDao;

    @Autowired
    public EmployeeService(IEmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
    @Override
    public List<Employee> findAll() {
        return this.employeeDao.findAll();
    }

    @Override
    public Employee findById(int id) {
        return this.employeeDao.findById(id);
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {
        return this.employeeDao.save(employee);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        this.employeeDao.deleteById(id);
    }
}
