package com.cycloneboy.controller;

import com.cycloneboy.domain.RequestMessage;
import com.cycloneboy.domain.ResponseMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * Created by CycloneBoy on 2017/7/19.
 */
@Controller
public class WsController {

    @MessageMapping("/welcome")
    @SendTo("/topic/getResponse")
    public ResponseMessage say(RequestMessage message){
        System.out.println(message.getName());
        return new ResponseMessage("welcome, " + message.getName() + "!");
    }

}
