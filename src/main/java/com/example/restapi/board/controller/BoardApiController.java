package com.example.restapi.board.controller;

import com.example.restapi.board.db.BoardEntity;
import com.example.restapi.board.model.BoardDto;
import com.example.restapi.board.model.BoardRequest;
import com.example.restapi.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("api/board")
@RequiredArgsConstructor
public class BoardApiController {

    private final BoardService boardService;
    @PostMapping("")
    public BoardDto create(
        @Valid
        @RequestBody
        BoardRequest boardRequest
    ) {
        return boardService.create(boardRequest);
    }

    @GetMapping("/id/{id}")
    public BoardDto view(
        @PathVariable Long id
    ) {
        var entity = boardService.view(id);
        log.info("result : {}", entity);
        return boardService.view(id);
    }

}
