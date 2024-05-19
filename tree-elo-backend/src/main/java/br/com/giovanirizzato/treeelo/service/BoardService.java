package br.com.giovanirizzato.treeelo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.giovanirizzato.treeelo.model.Board;
import br.com.giovanirizzato.treeelo.repository.BoardRepository;

import java.util.Collection;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    public Collection<Board> getAllBoards() {
        return this.boardRepository.findAll();
    }
}
