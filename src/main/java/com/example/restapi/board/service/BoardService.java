package com.example.restapi.board.service;

import com.example.restapi.board.db.BoardEntity;
import com.example.restapi.board.db.BoardRepository;
import com.example.restapi.board.model.BoardDto;
import com.example.restapi.board.model.BoardRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final BoardConverter boardConverter;

    public BoardDto create(
        BoardRequest boardRequest
    ) {
        var entity = BoardEntity.builder()
                .boardName(boardRequest.getBoardName())
                .status("REGISTERED")
                .build();

        var saveEntity = boardRepository.save(entity);

        return boardConverter.toDto(saveEntity);
    }

    public BoardDto view(Long id) {
        var entity = boardRepository.findById(id).get();
        return boardConverter.toDto(entity);
    }
}
