package com.gestionStock.util;

import com.gestionStock.model.Adresse;
import com.gestionStock.model.Client;

public class ClientAdresse {

	private Client client;
	private Adresse adresse;

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public ClientAdresse() {
	}

	public ClientAdresse(Client client, Adresse adresse) {
		this.client = client;
		this.adresse = adresse;
	}

}
