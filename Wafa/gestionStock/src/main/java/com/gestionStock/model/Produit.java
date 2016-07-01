package com.gestionStock.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Produit {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idProduit", unique = true, nullable = false, length = 45)
	private Integer idProduit;
	private String serialNumber;
	private String description;
	private String fabriquant;
	private Date dateAchat;

	public Integer getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(Integer idProduit) {
		this.idProduit = idProduit;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFabriquant() {
		return fabriquant;
	}

	public void setFabriquant(String fabriquant) {
		this.fabriquant = fabriquant;
	}

	public Date getDateAchat() {
		return dateAchat;
	}

	public void setDateAchat(Date dateAchat) {
		this.dateAchat = dateAchat;
	}

	public Produit(Integer idProduit, String serialNumber, String description, String fabriquant, Date dateAchat) {
		super();
		this.idProduit = idProduit;
		this.serialNumber = serialNumber;
		this.description = description;
		this.fabriquant = fabriquant;
		this.dateAchat = dateAchat;
	}

	public Produit() {
		super();
	}

	public Produit(String serialNumber, String description, String fabriquant, Date dateAchat) {
		this.serialNumber = serialNumber;
		this.description = description;
		this.fabriquant = fabriquant;
		this.dateAchat = dateAchat;
	}

}
