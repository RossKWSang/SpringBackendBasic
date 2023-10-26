package com.example.restapi.board.service;

import com.example.restapi.board.db.BoardEntity;
import com.example.restapi.board.db.BoardRepository;
import com.example.restapi.board.model.BoardRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public BoardEntity create(
        BoardRequest boardRequest
    ) {
        var entity = BoardEntity.builder()
                .boardName(boardRequest.getBoardName())
                .status("REGISTERED")
                .build();
        return boardRepository.save(entity);
    }

}
