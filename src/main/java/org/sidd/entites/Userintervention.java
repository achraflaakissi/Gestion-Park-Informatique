package org.sidd.entites;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Userintervention  implements Serializable {
	@Id @GeneratedValue
	private Long id;
	@ManyToOne
	@JoinColumn(name="CODE_USER")
	private User user;
	@ManyToOne
	@JoinColumn(name="CODE_INRT")
	private Intervention intervention;
}
