package br.com.giovanirizzato.treeelo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.giovanirizzato.treeelo.model.Board;
import br.com.giovanirizzato.treeelo.model.Board.CreateDto;
import br.com.giovanirizzato.treeelo.model.security.User;
import br.com.giovanirizzato.treeelo.repository.BoardRepository;

import java.util.Collection;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    public Collection<Board> getAllBoards() {
        return this.boardRepository.findAll();
    }

    public Collection<Board> getAllBoardsForUser(User user) {
        return this.boardRepository.findByUsersWithAccess(user);
    }

    public Board createBoard(CreateDto createDto, User user) {
        final Board newBoard = new Board();
        newBoard.setName(createDto.name());
        newBoard.setOwner(user);
        newBoard.getUsersWithAccess().add(user);
        return boardRepository.save(newBoard);
    }
}
