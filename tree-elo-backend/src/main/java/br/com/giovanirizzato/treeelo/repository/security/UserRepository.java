package br.com.giovanirizzato.treeelo.repository.security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import br.com.giovanirizzato.treeelo.model.security.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    UserDetails findByLogin(String login);
}
