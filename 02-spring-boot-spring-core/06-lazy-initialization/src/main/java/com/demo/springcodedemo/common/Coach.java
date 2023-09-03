package com.demo.springcodedemo.common;

import org.springframework.stereotype.Component;

@Component
public class Coach implements ICoach {
    public Coach() {
        System.out.println("In constructor: "+ getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes!!!!";
    }
}
