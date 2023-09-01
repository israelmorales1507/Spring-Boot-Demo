package com.demo.springcodedemo;

import org.springframework.stereotype.Component;

@Component
public class Coach implements ICoach {

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes!!!!";
    }
}
