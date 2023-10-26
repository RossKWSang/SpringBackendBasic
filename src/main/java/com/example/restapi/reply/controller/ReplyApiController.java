package com.example.restapi.reply.controller;

import com.example.restapi.post.db.PostEntity;
import com.example.restapi.post.model.PostRequest;
import com.example.restapi.reply.db.ReplyEntity;
import com.example.restapi.reply.model.ReplyRequest;
import com.example.restapi.reply.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/reply")
@RequiredArgsConstructor
public class ReplyApiController {
    private final ReplyService replyService;

    @PostMapping("")
    public ReplyEntity create(
            @Valid
            @RequestBody ReplyRequest replyRequest
    ) {
        return replyService.create(replyRequest);
    }
}

