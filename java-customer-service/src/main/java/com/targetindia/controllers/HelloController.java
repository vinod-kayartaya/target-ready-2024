package com.targetindia.controllers;

import com.targetindia.model.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping(produces = "text/plain")
    public String handleGetText() {
        return "Hello, world!";
    }

    @GetMapping(produces = {"application/json", "application/xml"})
    public Greeting handleGetJson() {
        return new Greeting("Hello, world!");
    }
}
