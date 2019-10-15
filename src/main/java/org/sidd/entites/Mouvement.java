package org.sidd.entites;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.sidd.entites.Article;
import org.sidd.entites.Emplacement;
import org.sidd.entites.Stock;
import org.sidd.entites.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Mouvement {
	@Id @GeneratedValue
	private Long id;
	private Date date_mouvement;
	private String type;

	@ManyToOne
	@JoinColumn(name="CODE_USER")
	private User user;

	@ManyToOne
	@JoinColumn(name="CODE_PRS")
	private Personnel personnel;
	
	@ManyToOne
	@JoinColumn(name="CODE_ART")
	private Article article;
	
	@ManyToOne
	@JoinColumn(name="CODE_STOCK")
	private Stock stock;
	
	@ManyToOne
	@JoinColumn(name="CODE_EPL")
	private Emplacement emplacement;
}
