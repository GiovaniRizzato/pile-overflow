package br.com.giovanirizzato.treeelo.model;

import java.util.Set;

import br.com.giovanirizzato.treeelo.model.security.User;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Board{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)     
	private Integer id;

	private String name;

	@ManyToOne
	private User owner;

	@ManyToMany
	@JoinTable(
		name = "board_user_access", 
		joinColumns = @JoinColumn(name = "BOARD_id"), 
		inverseJoinColumns = @JoinColumn(name = "APPLICATION_USER_id"))
	private Set<User> usersWithAccess;
}