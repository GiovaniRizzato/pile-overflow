package br.com.giovanirizzato.treeelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.giovanirizzato.treeelo.model.Board;

@Repository
public interface BoardRepository extends JpaRepository<Board, Integer> {
}
