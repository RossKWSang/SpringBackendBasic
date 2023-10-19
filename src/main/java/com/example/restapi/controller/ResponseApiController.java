package com.example.restapi.controller;

import com.example.restapi.model.UserRequest;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ResponseApiController {

    // http://localhost:8080/api/v1
    @GetMapping("")
    public UserRequest user() {
        var user = new UserRequest();
        user.setUserName("홍길동");
        user.setUserAge(10);
        user.setEmail("hong@gmail.com");
        return user;
    }
}
