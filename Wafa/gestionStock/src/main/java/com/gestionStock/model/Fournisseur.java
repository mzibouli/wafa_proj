package com.gestionStock.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Fournisseur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false, length = 45)
	private Integer id;
	@Column(name = "nomEntreprise", unique = true, nullable = false, length = 60)
	private String nomEntreprise;
	private String tel;
	private String email;
	@OneToOne()
	private Adresse adresse;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "FOURNISSEUR_PRODUIT", joinColumns = @JoinColumn(name = "id") , inverseJoinColumns = @JoinColumn(name = "idPiece") )
	private Set<Produit> produits = new HashSet<Produit>(0);

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomEntreprise() {
		return nomEntreprise;
	}

	public void setNomEntreprise(String nomEntreprise) {
		this.nomEntreprise = nomEntreprise;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Set<Produit> getProduits() {
		return produits;
	}

	public void setProduits(Set<Produit> produits) {
		this.produits = produits;
	}

	public Fournisseur() {

	}

	public Fournisseur(String nomEntreprise, String tel, String email, Adresse adresse) {
		super();
		this.nomEntreprise = nomEntreprise;
		this.tel = tel;
		this.email = email;
		this.adresse = adresse;
	}

	public Fournisseur(Integer id, String nomEntreprise, String tel, String email, Adresse adresse) {
		super();
		this.id = id;
		this.nomEntreprise = nomEntreprise;
		this.tel = tel;
		this.email = email;
		this.adresse = adresse;
	}

}
