package com.cycloneboy.controller;

import com.cycloneboy.domain.Demo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by CycloneBoy on 2017/7/14.
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @RequestMapping("/getDemo")
    public Demo getDemo(){
        Demo demo = new Demo(1L,"Angel");
        return  demo;
    }

}
