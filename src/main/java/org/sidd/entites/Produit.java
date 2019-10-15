package org.sidd.entites;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor
public class Produit {
	@Id @GeneratedValue
	private Long id;
	private String nom;
	private String mark;
	private String modele;
	private String sn;
	private String designation;
	private String type;
}
