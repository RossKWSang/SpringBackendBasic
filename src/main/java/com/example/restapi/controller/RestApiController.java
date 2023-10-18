package com.example.restapi.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class RestApiController {
    @GetMapping(path="/hello")
    public String hello() {
        var html = "<html><body><h1>Hello Spring Boot</h1></body></html>";
        return html;
    }

    @GetMapping(path="/echo/{message}/age/{age}/is-man/{isMan}")
    public String echo(
            @PathVariable(name="message") String msg,
            @PathVariable int age,
            @PathVariable boolean isMan
    ) {
        System.out.println("echo message: " + msg);
        System.out.println("echo message: " + age);
        System.out.println("echo message: " + isMan);

        // TODO 대문자로 변환해서 RETURN

        return msg.toUpperCase();
    }

    // http://localhost:8080/book?category=IT&issuedYear=2023&issued-month=01&issued_day=31
    @GetMapping(path="/book")
    public String queryParam(
        @RequestParam String category,
        @RequestParam String issuedYear,
        @RequestParam(name="issued-month") String issuedMonth,
        @RequestParam String issued_day
    ) {
        return "hello";
    }

    @GetMapping(path="/book2")
    public String queryParamDto(
            @RequestParam String category,
            @RequestParam String issuedYear,
            @RequestParam(name="issued-month") String issuedMonth,
            @RequestParam String issued_day
    ) {
        return "hello";
    }
}
