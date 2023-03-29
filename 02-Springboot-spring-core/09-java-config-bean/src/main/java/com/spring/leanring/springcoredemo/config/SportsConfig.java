package com.spring.leanring.springcoredemo.config;

import com.spring.leanring.springcoredemo.common.Coach;
import com.spring.leanring.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportsConfig {

    @Bean("aquatic")
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
