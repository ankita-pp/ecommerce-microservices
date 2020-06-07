package com.example.demo.controller;

import com.example.demo.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class TestController {
    private final TestService testService;
    private final MessageSource messageSource;

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

    @GetMapping("/test-i18n")
    public String getGoodMorningMessage(Locale locale) {
        return messageSource.getMessage("morning.message", null, locale);
    }

}
