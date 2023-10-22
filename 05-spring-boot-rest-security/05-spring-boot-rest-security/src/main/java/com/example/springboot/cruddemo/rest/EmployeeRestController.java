package com.example.springboot.cruddemo.rest;

import com.example.springboot.cruddemo.entity.Employee;
import com.example.springboot.cruddemo.service.IEmployeeService;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private IEmployeeService employeeService;

    @Autowired
    public EmployeeRestController (IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return this.employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee findById(@PathVariable int id) {
        var result = this.employeeService.findById(id);
        if (result == null) {
            throw new RuntimeException("Employee id:"+id+" not found.");
        }
        return result;
    }

    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee) {
        return this.employeeService.save(employee);
    }

    @PutMapping("/employees")
    public Employee UpdateEmployee(@RequestBody Employee employee) {
        return this.employeeService.save(employee);
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id){
        var employee = this.employeeService.findById(id);
        if (employee == null) {
            throw new RuntimeException("Employee id:"+id+"not found.");
        }
        this.employeeService.deleteById(id);
        return "Deleted Employee id: " +id;
    }
}
