package org.sidd.entites;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
public class Etudiant {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String prenom;
	private Date datenaissance;
	
	public Etudiant(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}

	public Etudiant() {
		super();
	}
	
}
