package com.example.springbootonline2.controller;

import com.example.springbootonline2.model.MessageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    @ResponseBody
    public MessageInfo sayHello() {
//        return "Hello world, welcome to spring boot.";
        MessageInfo messageInfo = new MessageInfo();
        messageInfo.setMessage("Hello world, welcome to spring boot.");

        return messageInfo;
    }
}
