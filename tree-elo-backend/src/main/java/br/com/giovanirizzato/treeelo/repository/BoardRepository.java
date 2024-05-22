package br.com.giovanirizzato.treeelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

import br.com.giovanirizzato.treeelo.model.Board;
import br.com.giovanirizzato.treeelo.model.security.User;


@Repository
public interface BoardRepository extends JpaRepository<Board, Integer> {

    Collection<Board> findByUsersWithAccess(User usersWithAccess);
}
