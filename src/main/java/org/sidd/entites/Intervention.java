package org.sidd.entites;

import java.io.Serializable;
import java.sql.Time;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Intervention  implements Serializable {
	@Id @GeneratedValue
	private Long id;
	private String type;
	private String typeemplacement;
	private String equipe;
	private String object;
	private String prestation;
	private String description;
	@Temporal(TemporalType.DATE)
	private Date date_reclamation;
	@Temporal(TemporalType.DATE)
	private Date date_intervention;
	private String heure_intervention;
	@Temporal(TemporalType.DATE)
	private Date date_prestation;
	private String heure_prestation;
	private Integer duree_intervention;
	private Boolean valider;
	private Boolean validerresponsable;
	@ManyToOne
	@JoinColumn(name="CODE_PRS")
	private Personnel personnel;
	@ManyToOne
	@JoinColumn(name="CODE_EPL")
	private Emplacement emplacement;
	@ManyToOne
	@JoinColumn(name="CODE_STOCK")
	private Stock stock;
	@OneToMany(mappedBy="intervention",fetch=FetchType.LAZY)
	private Collection<Userintervention> userinterventions;
}
