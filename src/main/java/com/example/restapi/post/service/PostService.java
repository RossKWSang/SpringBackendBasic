package com.example.restapi.post.service;

import com.example.restapi.post.db.PostEntity;
import com.example.restapi.post.db.PostRepository;
import com.example.restapi.post.model.PostRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public PostEntity create(
        PostRequest postRequest
    ) {
        var entity = PostEntity.builder()
                .boardId(1L) // 임시고정
                .userName(postRequest.getUserName())
                .password(postRequest.getPassword())
                .email(postRequest.getEmail())
                .status("REGISTERED")
                .title(postRequest.getTitle())
                .content(postRequest.getContent())
                .postedAt(LocalDateTime.now())
                .build();

        return postRepository.save(entity);
    }
}
