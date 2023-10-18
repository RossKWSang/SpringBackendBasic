package com.example.restapi.controller;

import com.example.restapi.model.BookQueryParam;
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

    // http://localhost:8080/api/book2?category=hello&issuedYear=2023&issuedMonth=09&issuedDay=20
    @GetMapping(path="/book2")
    public String queryParamDto(
        BookQueryParam bookQueryParam
    ) {
        System.out.println(bookQueryParam);
        return "hello";
    }

    // TODO Parameter 2가지를 받습니다. int 형태로 받아서 두 수의 덧셈과 곱셈을 수행
    // TODO String 타입 boolean 타입도 받아볼 것
    @GetMapping(path="/add/{integer1}/{integer2}")
    public int addTwoInt(
            @PathVariable int integer1,
            @PathVariable int integer2) {
        return integer1 + integer2;
    }

    @GetMapping(path="/bool/{boolInput}")
    public boolean booleanQuery(
            @PathVariable boolean boolInput) {
        return boolInput;
    }

}
