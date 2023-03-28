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
    private Coach anotherCoach;

    //setter Injection
    @Autowired
    public DemoController(@Qualifier("cricketCoach") Coach theCoach,
                          @Qualifier("cricketCoach") Coach theOtherCoach){
        System.out.println("In Constructor: "  + getClass().getSimpleName());
        myCoach = theCoach;
        anotherCoach = theOtherCoach;
    }

    @GetMapping("/check")
    public String check(){
        return "Comparing beans: myCoach == anotherCoach, " + (myCoach == anotherCoach);
    }



    @GetMapping("/dailyWorkout")
        public String getDailyWorkout(){
            return myCoach.getDailyWorkout();
        }






}
