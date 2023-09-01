package com.demo.springcodedemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    public ICoach coach;

    @Autowired
    DemoController(ICoach coach){
        this.coach = coach;
    }

    @GetMapping("/getDailyWorkout")
    public String getDailyWOrkout() {
        return this.coach.getDailyWorkout();
    }
}
