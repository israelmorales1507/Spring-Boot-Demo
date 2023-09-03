package com.demo.springcodedemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class BaseBallCoach implements ICoach{

    @Override
    public String getDailyWorkout() {
        return "Spring 30 minutes in batting practice";
    }
}
