package org.sidd.entites;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Personnel {

	@Id @GeneratedValue
	private Long id;
	private String fullname;
	private String login;
	private String password;
	private String status;
	private String designation;
	private String role;
	@OneToMany(mappedBy="responsable",fetch=FetchType.LAZY)
	private Collection<Direction> directions;
	@OneToMany(mappedBy="personnel",fetch=FetchType.LAZY)
	private Collection<Mouvement> mouvements;
	@OneToMany(mappedBy="empresp",fetch=FetchType.LAZY)
	private Collection<Emplacement> emplacements;
	@OneToMany(mappedBy="personnel",fetch=FetchType.LAZY)
	private Collection<Intervention> intervention;
}
