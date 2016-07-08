package com.gestionStock.util;

import com.gestionStock.model.Adresse;
import com.gestionStock.model.Technicien;

public class TechnicienAdresse {
	private Technicien technicien;
	private Adresse adresse;
	public Technicien getTechnicien() {
		return technicien;
	}
	public void setTechnicien(Technicien technicien) {
		this.technicien = technicien;
	}
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	public TechnicienAdresse(Technicien technicien, Adresse adresse) {
		this.technicien = technicien;
		this.adresse = adresse;
	}
	public TechnicienAdresse() {
	}
	

}
