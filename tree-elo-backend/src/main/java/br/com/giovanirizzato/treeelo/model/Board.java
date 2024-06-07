package br.com.giovanirizzato.treeelo.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Board{

	public record CreateDto(
		String name) {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)     
	private Integer id;

	private String name;

	@OneToMany(mappedBy = "board")
	private List<Column> columns = new ArrayList<>();

	@ManyToOne
	private User owner;

	@ManyToMany
	@JoinTable(
		name = "board_user_access", 
		joinColumns = @JoinColumn(name = "BOARD_id"), 
		inverseJoinColumns = @JoinColumn(name = "APPLICATION_USER_id"))
	private Set<User> usersWithAccess = new HashSet<>();
}