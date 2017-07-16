package com.cycloneboy.controller;

import com.cycloneboy.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by CycloneBoy on 2017/7/15.
 */
@RestController
public class HomeController {

    private static Logger logger = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ModelAndView home(Model model , HttpSession session){
        logger.info("url=\"home ...");
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        model.addAttribute("name","CycloneBoy");
        model.addAttribute("today",sdf.format(date));


        model.addAttribute("date", Calendar.getInstance());
        session.setAttribute("user",new User(1L,"cycloneboy",24));

        return  new ModelAndView("home");
    }

    @RequestMapping(value = "/subscribe",method = RequestMethod.GET)
    public ModelAndView getSubscribe(){

        return  new ModelAndView("subscribe");
    }

    @RequestMapping(value = "/subscribe",method = RequestMethod.POST)
    public String postSubscribe(String email ){

        logger.info("订阅的邮件信息: " + email);

        return "/";
    }

    @RequestMapping(value = "/userprofile",method = RequestMethod.GET)
    public ModelAndView getUserprofile(){

        return new ModelAndView("userprofile");
    }
}
