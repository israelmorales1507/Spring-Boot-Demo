package com.example.springboot.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

    // new a controller method to show initial HTML Form.
    @RequestMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }

    // need a controller method to process the HTML Form.
    @RequestMapping("processForm")
    public String processForm(){
        return "helloworld";
    }

    // need a controller method to read form data and
    // add data to the model
    @RequestMapping("/processFormVersionTwo")
    public String lesShoutDude(HttpServletRequest request, Model model){
        String theName = request.getParameter("studentName");
        theName = theName.toUpperCase();
        String result = "Yo! " + theName;
        model.addAttribute("message",result);
        return "helloworld";
    }
}
