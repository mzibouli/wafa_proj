package com.gestionStock.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "ADRESSE", catalog = "gestionstock")
public class Adresse implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false, length = 45)	
	private Integer id;
	
	@Column(name = "numeroCivil", nullable = true, length = 60)
	private String numeroCivil;
	
	@Column(name = "codePostal", nullable = true, length = 60)
	private String codePostal;
	
	@Column(name = "ville", nullable = true, length = 60)
	private String ville;
	
	@Column(name = "rue", nullable = true, length = 60)
	private String rue;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumeroCivil() {
		return numeroCivil;
	}

	public void setNumeroCivil(String numeroCivil) {
		this.numeroCivil = numeroCivil;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public Adresse(){};
	public Adresse(String numeroCivil, String codePostal, String ville, String rue) {
		this.numeroCivil = numeroCivil;
		this.codePostal = codePostal;
		this.ville = ville;
		this.rue = rue;
	}

}
