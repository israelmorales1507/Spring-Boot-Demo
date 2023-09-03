package com.demo.springcodedemo.common;

public class SwimCoach implements ICoach {

    public SwimCoach(){
        System.out.println("In constructor: "+getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Swin 1000 meters as a warm up";
    }
}
