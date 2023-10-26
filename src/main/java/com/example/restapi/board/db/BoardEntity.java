package com.example.restapi.board.db;

import com.example.restapi.post.db.PostEntity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity(name = "board")
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String boardName;

    private String status;

    @OneToMany(mappedBy = "board") // OneToMany가 있을 때는 Transient는 없어도 됨
    private List<PostEntity> postList;
}
