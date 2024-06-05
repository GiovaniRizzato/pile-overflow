package br.com.giovanirizzato.treeelo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Column{

	public record CreateDto(
		String name) {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)     
	private Integer id;

	private String name;

	@ManyToOne
	private Board board;
}