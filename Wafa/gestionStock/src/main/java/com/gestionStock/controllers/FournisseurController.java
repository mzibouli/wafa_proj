package com.gestionStock.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gestionStock.model.Adresse;
import com.gestionStock.model.Fournisseur;
import com.gestionStock.repositoryServiceImpl.AdresseRepositoryServiceImpl;
import com.gestionStock.repositoryServiceImpl.FournisseurRepositoryServiceImpl;
import com.gestionStock.util.FournisseurAdresse;

@RestController
@RequestMapping("/fournisseur")
public class FournisseurController {
	@RequestMapping(value = "/tousLesFournisseurs", method = RequestMethod.GET)
	public Iterable<Fournisseur> tousLesFournisseur() {
		Iterable<Fournisseur> fournisseurs = fournisseurRepositoryServiceImpl.findAll();
		return fournisseurs;
	}

	@RequestMapping(value = "/creerFournisseur", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public FournisseurAdresse createFournisseur(@RequestBody String formFournisseurAdresse) {

		ObjectMapper mapper = new ObjectMapper();
		Fournisseur fournisseur = null;
		FournisseurAdresse fournisseurAdresse = null;
		Adresse adresse = null;
		try {
			fournisseurAdresse = mapper.readValue(formFournisseurAdresse, FournisseurAdresse.class);
			fournisseur = fournisseurAdresse.getFournisseur();
			adresse = fournisseurAdresse.getAdresse();
			fournisseur.setAdresse(adresse);
			adresseRepositoryServiceImpl.save(adresse);
			fournisseurRepositoryServiceImpl.save(fournisseur);
		} catch (JsonGenerationException e) {

			e.printStackTrace();

		} catch (JsonMappingException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
		return fournisseurAdresse;
	}

	@Autowired
	FournisseurRepositoryServiceImpl fournisseurRepositoryServiceImpl;
	@Autowired
	AdresseRepositoryServiceImpl adresseRepositoryServiceImpl;
}
