package com.example.restapi.board.model;

import com.example.restapi.post.db.PostEntity;
import com.example.restapi.post.model.PostDto;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class BoardDto {
    private Long id;

    private String boardName;

    private String status;

    private List<PostDto> postList;
}
