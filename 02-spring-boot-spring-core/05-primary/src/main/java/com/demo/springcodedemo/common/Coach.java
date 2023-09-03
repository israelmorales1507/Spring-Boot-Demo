package com.demo.springcodedemo.common;

import org.springframework.stereotype.Component;

@Component
public class Coach implements ICoach {

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes!!!!";
    }
}
