package com.spring.leanring.springcoredemo.rest;


import com.spring.leanring.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    //define private field for dependency
    private Coach myCoach;

    //setter Injection
    @Autowired
    public DemoController(@Qualifier("trackCoach") Coach theCoach){
        myCoach = theCoach;
    }



    @GetMapping("/dailyWorkout")
        public String getDailyWorkout(){
            return myCoach.getDailyWorkout();
        }






}
