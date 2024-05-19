package br.com.giovanirizzato.treeelo.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.giovanirizzato.treeelo.model.Board;
import br.com.giovanirizzato.treeelo.service.BoardService;

@RestController
@RequestMapping("/boards")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping()
    public ResponseEntity<Collection<Board>> getAllBoards() {
            return ResponseEntity
                .status(HttpStatus.OK)                 
                .body(boardService.getAllBoards());      
    }
}
