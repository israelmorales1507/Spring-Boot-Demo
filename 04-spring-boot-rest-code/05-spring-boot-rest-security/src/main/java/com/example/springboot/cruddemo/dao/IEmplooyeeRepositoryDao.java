package com.example.springboot.cruddemo.dao;

import com.example.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmplooyeeRepositoryDao extends JpaRepository<Employee, Integer> {
}
