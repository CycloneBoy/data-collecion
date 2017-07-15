package com.cycloneboy.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by CycloneBoy on 2017/7/14.
 */

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String index(){
        return "Hello World";
    }

    @RequestMapping("/h")
    public String home(){
        return "this is user !";
    }

   @RequestMapping("/index")
    public String index(ModelMap map){
        map.addAttribute("host","https://github.com/CycloneBoy");
        return "index";
   }
}
