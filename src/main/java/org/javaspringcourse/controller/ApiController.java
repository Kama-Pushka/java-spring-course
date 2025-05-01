package org.javaspringcourse.controller;

import org.javaspringcourse.RequestsLimit.RequestsLimit;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

    @RequestsLimit
    @GetMapping("/getHelloWorld")
    public String getHelloWorld() {
        return "Hello World";
    }

    @RequestsLimit
    @GetMapping("/getByeWorld")
    public String getByeWorld() {
        return "Bye World";
    }
}
