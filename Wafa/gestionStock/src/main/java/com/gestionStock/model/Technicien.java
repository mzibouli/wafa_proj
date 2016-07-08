package com.gestionStock.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;



@Entity
@Table(name = "TECHNICIEN", catalog = "gestionstock")
public class Technicien {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false, length = 45)
	private Integer id;
	
/*	@Column(name = "idTechnicien", unique = true, nullable = true, length = 45)
	private String idTechnicien;*/
	
	@Column(name = "nom", nullable = false, length = 60)
	private String nom;
	
	@Column(name = "prenom", nullable = false, length = 60)
	private String prenom;
	
	@Column(name = "tel", nullable = false, length = 60)
	private String tel;

	@OneToOne()
	private Adresse adresse;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

/*	public String getIdTechnicien() {
		return idTechnicien;
	}

	public void setIdTechnicien(String idTechnicien) {
		this.idTechnicien = idTechnicien;
	}*/

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	public Technicien(Integer id, String nom, String prenom, String tel) {
		super();
		this.id = id;
		//this.idTechnicien = idTechnicien;
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
	}

	public Technicien() {

	}
	
	
}




