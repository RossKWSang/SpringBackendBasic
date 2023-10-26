package com.example.restapi.post.service;

import com.example.restapi.board.db.BoardRepository;
import com.example.restapi.post.db.PostEntity;
import com.example.restapi.post.db.PostRepository;
import com.example.restapi.post.model.PostRequest;
import com.example.restapi.post.model.PostViewRequest;
import com.example.restapi.reply.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final ReplyService replyService;
    private final BoardRepository boardRepository;

    public PostEntity create(
        PostRequest postRequest
    ) {
        var boardEntity = boardRepository.findById(postRequest.getBoardId()).get();

        var entity = PostEntity.builder()
                .board(boardEntity) // 임시고정
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

    /* 1. 게시글이 있는가?
    /  2. 비밀번호가 맞는가?
     */
    public PostEntity view(PostViewRequest postViewRequest) {
        return postRepository.findFirstByIdAndStatusOrderByIdDesc(postViewRequest.getPostId(), "REGISTERED")
                .map( it -> {
                    if(!it.getPassword().equals(postViewRequest.getPassword())){
                        var format = "패스워드가 맞지 않습니다 %s vs %s";

                        throw new RuntimeException(String.format(format, it.getPassword(), postViewRequest.getPassword()));
                    }

                    var replyList = replyService.findAllByPostId(it.getId());
                    it.setReplyList(replyList);

                    return it;

                        }).orElseThrow(
                        () -> {
                            return new RuntimeException("해당 게시글이 존재하지 않습니다 : " + postViewRequest.getPostId());
                        }
                );
    }

    public List<PostEntity> all() {
        return postRepository.findAll();
    }

    public void delete(PostViewRequest postViewRequest) {
        postRepository.findById(postViewRequest.getPostId())
                .map( it -> {
                    if(!it.getPassword().equals(postViewRequest.getPassword())){
                        var format = "패스워드가 맞지 않습니다 %s vs %s";

                        throw new RuntimeException(String.format(format, it.getPassword(), postViewRequest.getPassword()));
                    }
                    it.setStatus("UNREGISTERED");
                    postRepository.save(it);
                    return it;
                }).orElseThrow(
                        () -> {
                            return new RuntimeException("해당 게시글이 존재하지 않습니다 : " + postViewRequest.getPostId());
                        }
                );
    }
}
