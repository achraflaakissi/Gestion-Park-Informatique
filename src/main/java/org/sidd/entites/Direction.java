package org.sidd.entites;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Direction {
	@Id @GeneratedValue
	private Long id;
	private String nom;
	@OneToMany(mappedBy="direction",fetch=FetchType.LAZY)
	private Collection<Emplacement> emplacements;
	@ManyToOne
	@JoinColumn(name="CODE_PRS")
	private Personnel responsable;
}
