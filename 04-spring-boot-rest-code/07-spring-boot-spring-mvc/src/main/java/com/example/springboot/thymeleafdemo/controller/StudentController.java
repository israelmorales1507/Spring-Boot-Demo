package com.example.springboot.thymeleafdemo.controller;

import com.example.springboot.thymeleafdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Value("${countries}")
    private List<String> countries;
    @GetMapping("/showStudentForm")
    public String showForm(Model model){
        // create a new student object
        Student student = new Student();
        // add student object to the model.
        model.addAttribute("student", student);
        // add the list of countries to the model
        model.addAttribute("countries", countries);
        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student") Student student){
        // log the input data
        System.out.println("The Student: "+student.getFirstName() + " " + student.getLastName());
        return "student-confirmation";
    }
}
