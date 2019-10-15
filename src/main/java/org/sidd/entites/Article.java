package org.sidd.entites;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.sidd.entites.Mouvement;
import org.springframework.beans.factory.annotation.Value;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor
public class Article implements Serializable {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String mark;
	private String modele;
	private String sn;
	private String designation;
	private String type;
	private String cpu;
	private String ram;
	private String hdd;
	private String pouce;
	private String port;
	private String lumens;
	private String length;
	private int qtte;
	private Date date_mise_service;
	private String unite;
	private String sessionlogin;
	private String sessionpassword;
	private boolean antivirus;
	private String antiviruslicence;
	private boolean anydesk;
	private String anydeskid;
	private String anydeskpassword;
	private boolean eyebeam;
	private String eyebeamSIP;
	private String fqdn;
	private String system;
	private String wifissid;
	private String wifipass;
	private String ip;
	private boolean materialdonner = false;
	private String type_emplacement;
	@OneToMany(mappedBy="article",fetch=FetchType.LAZY)
	private Collection<Mouvement> mouvements;
	@ManyToOne
	@JoinColumn(name="CODE_STOCK")
	private Stock stock;
	@ManyToOne
	@JoinColumn(name="CODE_EPL")
	private Emplacement emplacement;
	
	public Article() {
		super();
	}
	public Article(String nom, String mark, String modele, String sn, String designation, String type, String unite) {
		this.nom = nom;
		this.mark = mark;
		this.modele = modele;
		this.sn = sn;
		this.designation = designation;
		this.type = type;
		this.unite = unite;
	}
	public Article(String nom, String mark, String modele, String sn, String designation, String type, String cpu,
			String ram, String hdd, String pouce, String port, String lumens, String length, int qtte) {
		super();
		this.nom = nom;
		this.mark = mark;
		this.modele = modele;
		this.sn = sn;
		this.designation = designation;
		this.type = type;
		this.cpu = cpu;
		this.ram = ram;
		this.hdd = hdd;
		this.pouce = pouce;
		this.port = port;
		this.lumens = lumens;
		this.length = length;
	}
	
}
