package com.demo.springcodedemo.common;

import org.springframework.stereotype.Component;

@Component
public class BaseBallCoach implements ICoach{

    @Override
    public String getDailyWorkout() {
        return "Spring 30 minutes in batting practice";
    }
}
