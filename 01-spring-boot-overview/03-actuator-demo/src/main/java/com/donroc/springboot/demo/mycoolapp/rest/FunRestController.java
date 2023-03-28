package com.donroc.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @Value("${coach.name}")
    private String coachName;


    //Default mapping
    @GetMapping("/")
    public String defaultMessage(){
        return "App is under construction" + " by:" + coachName;
    }

    //expose a new endpoint for fortune
    @GetMapping("/fortune")
    public String fortune(){
        return "Today will be the best day of your life";
    }

    //expose a new endpoint for work
    @GetMapping("/work")
    public String doWork(){
        return "some work is being done";
    }
}
