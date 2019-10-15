package org.sidd.entites;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.sidd.entites.Mouvement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stock {
	@Id @GeneratedValue
	private Long id;
	private String nom;
	@OneToMany(mappedBy="stock",fetch=FetchType.LAZY)
	private Collection<Mouvement> mouvements;
	@OneToMany(mappedBy="stock",fetch=FetchType.LAZY)
	private Collection<Intervention> intervention;
	@OneToMany(mappedBy="stock",fetch=FetchType.LAZY)
	private Collection<Article> articles;
}
