package com.demo.springcodedemo.common;

import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements ICoach{
    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k!";
    }
}
