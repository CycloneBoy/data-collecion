package com.cycloneboy.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by CycloneBoy on 2017/7/14.
 */

@RestController
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        return "hello user!";
    }

    @RequestMapping("/h")
    public String home(){
        return "this is user !";
    }
}
