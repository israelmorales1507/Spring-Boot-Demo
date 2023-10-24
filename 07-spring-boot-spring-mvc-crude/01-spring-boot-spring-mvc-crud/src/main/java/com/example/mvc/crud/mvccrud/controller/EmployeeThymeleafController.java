package com.example.mvc.crud.mvccrud.controller;

import com.example.mvc.crud.mvccrud.entity.Employee;
import com.example.mvc.crud.mvccrud.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employees")
public class EmployeeThymeleafController {

    private final IEmployeeService employeeService;

    @Autowired
    public EmployeeThymeleafController(IEmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public String showEmployees(Model model){
        model.addAttribute("employees", this.employeeService.findAll());
        return "ListEmployees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){
        model.addAttribute("employee", new Employee());
        return "Employees/EmployeeForm";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        this.employeeService.save(employee);
        return "redirect:/employees/";
    }
}
