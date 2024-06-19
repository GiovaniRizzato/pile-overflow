package br.com.giovanirizzato.treeelo.controller;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.giovanirizzato.treeelo.model.Board;
import br.com.giovanirizzato.treeelo.model.Board.CreateDto;
import br.com.giovanirizzato.treeelo.model.security.User;
import br.com.giovanirizzato.treeelo.service.BoardService;

@RestController
@RequestMapping("/boards")
public class BoardController {
    @Autowired
    private BoardService boardService;

    @GetMapping()
    public ResponseEntity<Collection<Board>> getAllBoardsForUser(@AuthenticationPrincipal User user) {
        return ResponseEntity
            .status(HttpStatus.OK)                 
            .body(boardService.getAllBoardsForUser(user));      
    }

    @PostMapping()
    public ResponseEntity<Board> createBoard(@AuthenticationPrincipal User user, @RequestBody @Valid CreateDto createDto) {
        return ResponseEntity
            .status(HttpStatus.CREATED)                 
            .body(boardService.createBoard(createDto, user));      
    }
}
