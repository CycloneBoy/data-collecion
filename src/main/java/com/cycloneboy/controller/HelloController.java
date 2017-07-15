package com.cycloneboy.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by CycloneBoy on 2017/7/14.
 */

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String index(){
        return "Hello World";
    }

    @RequestMapping("/h")
    public String home(){
        return "this is user !";
    }


}
