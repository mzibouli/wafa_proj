package com.gestionStock.util;

import com.gestionStock.model.Adresse;
import com.gestionStock.model.Fournisseur;

public class FournisseurAdresse {
	
	private   Fournisseur fournisseur;
	private   Adresse adresse;
	public Fournisseur getFournisseur() {
		return fournisseur;
	}
	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	public FournisseurAdresse(Fournisseur fournisseur, Adresse adresse) {
		this.fournisseur = fournisseur;
		this.adresse = adresse;
	}
	public FournisseurAdresse() {
	}
	
	
	
}
