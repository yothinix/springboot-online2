package com.example.springbootonline2.controller;

import com.example.springbootonline2.model.MessageInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public MessageInfo sayHello() {
        MessageInfo messageInfo = new MessageInfo();
        messageInfo.setMessage("Hello world, welcome to spring boot.");

        return messageInfo;
    }
}
