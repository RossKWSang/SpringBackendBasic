package com.example.restapi.post.controller;

import com.example.restapi.post.db.PostEntity;
import com.example.restapi.post.model.PostRequest;
import com.example.restapi.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/post")
@RequiredArgsConstructor
public class PostApiController {
    private final PostService postService;

    @PostMapping("")
    public PostEntity create(
        @Valid
        @RequestBody
        PostRequest postRequest
    ) {
        return postService.create(postRequest);
    }
}
