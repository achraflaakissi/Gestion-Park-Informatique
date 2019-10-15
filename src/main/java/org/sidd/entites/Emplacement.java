package org.sidd.entites;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.sidd.entites.Mouvement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emplacement {
	@Id @GeneratedValue
	private Long id;
	private String nom;
	@OneToMany(mappedBy="emplacement",fetch=FetchType.LAZY)
	private Collection<Mouvement> mouvements;
	@OneToMany(mappedBy="emplacement",fetch=FetchType.LAZY)
	private Collection<Intervention> intervention;
	@OneToMany(mappedBy="emplacement",fetch=FetchType.LAZY)
	private Collection<Article> articles;
	@ManyToOne
	@JoinColumn(name="CODE_DRT")
	private Direction direction;
	@ManyToOne
	@JoinColumn(name="CODE_PRS")
	private Personnel empresp;
}
