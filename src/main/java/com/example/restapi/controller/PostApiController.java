package com.example.restapi.controller;

import com.example.restapi.model.BookRequest;
import com.example.restapi.model.MemberRequest;
import com.example.restapi.model.UserRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PostApiController {
    @PostMapping("/post")
    public String post(
            @RequestBody BookRequest bookRequest
    ) {
        System.out.println(bookRequest);
        return bookRequest.toString();
    }


    // TODO RequestBody로 사용자의 이름, 전화번호, 이메일을 받는 POST Method를 만들기
    @PostMapping("/member")
    public MemberRequest member(
            @RequestBody MemberRequest memberRequest
    ) {
        return memberRequest;
    }
//
//    @PostMapping("/user")
//    public UserRequest user(
//            @RequestBody UserRequest userRequest
//    ) {
//        System.out.println(userRequest);
//        return userRequest;
//    }
}
