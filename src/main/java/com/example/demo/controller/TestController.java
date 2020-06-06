package com.example.demo.controller;

import com.example.demo.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class TestController {
    private final TestService testService;

    @GetMapping("/hello")
    public String getHello() {
        return "Hello";
    }

    @GetMapping("/world")
    public String getWorld() {
        return "World";
    }

    @GetMapping("/rest-template-test")
    public String getHelloWorld() {
        return testService.getData();
    }

}
