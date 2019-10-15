package org.sidd.entites;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Reminder {
	@Id @GeneratedValue
	private Long id;
	private Date date=new Date();
	private String content;
	private Boolean valider=false;
	@ManyToOne
	@JoinColumn(name="CODE_USER")
	private User user;
}
