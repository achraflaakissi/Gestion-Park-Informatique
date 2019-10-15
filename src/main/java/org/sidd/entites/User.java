package org.sidd.entites;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {
	@Id @GeneratedValue
	private Long id;
	private String fullname;
	@Column(unique=true)
	private String username;
	private String password;
	private String status;
	private String designation;
	private String role;
	@OneToMany(mappedBy="user",fetch=FetchType.LAZY)
	private Collection<Mouvement> mouvements;
	@ManyToMany(fetch=FetchType.EAGER)
	private Collection<AppRole> roles = new ArrayList<>();
	@JsonSetter
	public void setPassword(String password) {
		this.password=password;
	}
	@JsonIgnore
	public String getPassword() {
		return this.password;
	}
}
