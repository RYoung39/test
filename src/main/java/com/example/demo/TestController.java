package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    //test

    @RequestMapping("hello")
    public String hello() {
        return "Hello";
    }
    @RequestMapping("hello1")
    public String hello1() {
        return "Hello World";
    }

}
