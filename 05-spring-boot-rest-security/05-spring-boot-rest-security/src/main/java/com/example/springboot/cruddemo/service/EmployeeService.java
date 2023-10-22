package com.example.springboot.cruddemo.service;

import com.example.springboot.cruddemo.dao.IEmplooyeeRepositoryDao;
import com.example.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.RuntimeMBeanException;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {

    private IEmplooyeeRepositoryDao employeeDao;

    @Autowired
    public EmployeeService(IEmplooyeeRepositoryDao employeeDao) {
        this.employeeDao = employeeDao;
    }
    @Override
    public List<Employee> findAll() {
        return this.employeeDao.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> result = this.employeeDao.findById(id);
        Employee theEmployee = null;
        if (result.isPresent()){
            theEmployee = result.get();
        }else {
            throw new RuntimeException("Did not found employee id:"+id);
        }
        return theEmployee;
    }

    @Override
    public Employee save(Employee employee) {
        return this.employeeDao.save(employee);
    }

    @Override
    public void deleteById(int id) {
        this.employeeDao.deleteById(id);
    }
}
