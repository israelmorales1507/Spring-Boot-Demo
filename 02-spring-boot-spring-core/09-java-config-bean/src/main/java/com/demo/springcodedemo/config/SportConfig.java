package com.demo.springcodedemo.config;

import com.demo.springcodedemo.common.ICoach;
import com.demo.springcodedemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
    @Bean
    public ICoach swimCoach() {
        return new SwimCoach();
    }
}
