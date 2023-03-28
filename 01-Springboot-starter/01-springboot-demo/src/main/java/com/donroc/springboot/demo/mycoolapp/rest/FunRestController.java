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
}
