package com.example.restapi.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(path="/api/b")
public class RestApiBController {

    // localhost:8080/api/b/hello
    @GetMapping(path="/hello")
    public void hello() {
        throw new NumberFormatException("number format exception");
    }
}
