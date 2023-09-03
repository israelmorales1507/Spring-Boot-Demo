package com.demo.springcodedemo.rest;

import com.demo.springcodedemo.common.ICoach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    public ICoach coach;
    public ICoach anotherCoach;

    @Autowired
    public DemoController(@Qualifier("trackCoach") ICoach coach,
                          @Qualifier("trackCoach") ICoach anotherCoach){
        System.out.println("In constructor: "+ getClass().getSimpleName());
        this.coach = coach;
        this.anotherCoach = anotherCoach;
    }

    @GetMapping("/check")
    public String check() {
        return "Comparing beans: " + (coach == anotherCoach);
    }
    @GetMapping("/getDailyWorkout")
    public String getDailyWOrkout() {
        return this.coach.getDailyWorkout();
    }
}
