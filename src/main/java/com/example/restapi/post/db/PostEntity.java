package com.example.restapi.post.db;

import com.example.restapi.board.db.BoardEntity;
import com.example.restapi.reply.db.ReplyEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity(name = "post")
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonIgnore // Post entity에서는 Board json을 만들지 않겠다
    @ToString.Exclude // Post entity에서는 String을 출력하지 않겠다
    private BoardEntity board;

    private String userName;
    private String password;
    private String email;
    private String status;
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;
    private LocalDateTime postedAt;

    @OneToMany(
            mappedBy = "post"
    )
    private List<ReplyEntity> replyList;
}
