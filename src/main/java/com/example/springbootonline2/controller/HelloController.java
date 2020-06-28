package com.example.springbootonline2.controller;

import com.example.springbootonline2.model.MessageInfo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public List<MessageInfo> sayHello() {
        MessageInfo messageInfo = new MessageInfo();
        messageInfo.setMessage("Hello world, welcome to spring boot.");

        List<MessageInfo> messageInfoList = new ArrayList<>();
        messageInfoList.add(messageInfo);
        return messageInfoList;
    }

    @RequestMapping("/hello/{id}")
    public MessageInfo getMessage(@PathVariable String id) {
        MessageInfo messageInfo = new MessageInfo();
        messageInfo.setMessage("This is message of id: " + id);
        return messageInfo;
    }

    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    public void postMessage(@RequestBody MessageInfo messageInfo) {
        System.out.println("message: " + messageInfo.getMessage());
    }

    @RequestMapping(value = "/hello/{id}", method = RequestMethod.PUT)
    public void putMessage(@PathVariable String id, @RequestBody MessageInfo messageInfo) {
        System.out.println("id: " + id);
        System.out.println("message: " + messageInfo.getMessage());
    }
}
