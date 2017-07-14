package com.cycloneboy.controller;

import org.springframework.beans.factory.FactoryBeanNotInitializedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.StringJoiner;

/**
 * Created by CycloneBoy on 2017/7/14.
 */
@RestController
@RequestMapping("/info")
public class InfoTagController {

    @Autowired
    private WebApplicationContext webApplicationContext;
    private final static LocalDateTime startDateTime = LocalDateTime.now();
    private final static DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("EEE, d MMM yyyy h:mm a");

    @RequestMapping("/server")
    @ResponseBody
    public String infoTagServer(){
        return new StringJoiner("<br>")
                .add("------------------------------------------")
                .add(" Server: " +
                webApplicationContext.getServletContext().getServerInfo())
                .add(" Start date : " +
                startDateTime.format(DATE_TIME_FORMATTER))
                .add(" Version: " +
                webApplicationContext.getBean("webAppVersion"))
                .add("---------------------------------------------")
                .toString();
    }

    @RequestMapping(value = "/helloHandler",method = RequestMethod.GET)
    @ResponseBody
    public  String helloController(){
        return "hello";
    }

    @RequestMapping("/")
    public String hello(){
        return "Hello World!";
    }

}
