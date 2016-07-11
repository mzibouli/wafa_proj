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
import com.gestionStock.model.Technicien;
import com.gestionStock.repository.AdresseRepository;
import com.gestionStock.repositoryServiceImpl.TechnicienRepositoryServiceImpl;
import com.gestionStock.util.TechnicienAdresse;

@RestController
@RequestMapping("/technicien")
public class TechnicienController {

	@RequestMapping(value = "/allTechniciens", method = RequestMethod.GET)
	public Iterable<Technicien> getAllTechniciens() {

		return technicienRepositoryServiceImpl.getAllTechniciens();

	}

	@RequestMapping(value = "/addTechniciens", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public TechnicienAdresse addTechniciens(@RequestBody String jsonTechnicienAdresse) {
		ObjectMapper mapper = new ObjectMapper();
		Technicien technicien = null;
		TechnicienAdresse technicienAdresse = null;
		Adresse adresse = null;
		try {
			technicienAdresse = mapper.readValue(jsonTechnicienAdresse, TechnicienAdresse.class);
			technicien = technicienAdresse.getTechnicien();
			technicien.setNom(technicien.getNom().toUpperCase());
			technicien.setPrenom(technicien.getPrenom().toUpperCase());
			adresse = technicienAdresse.getAdresse();
			technicien.setAdresse(adresse);
			if (adresse != null) {
				adresseRepository.save(adresse);
			}

			technicienRepositoryServiceImpl.addTechniciens(technicien);
		} catch (JsonGenerationException e) {

			e.printStackTrace();

		} catch (JsonMappingException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
		return technicienAdresse;
	}

	@Autowired
	TechnicienRepositoryServiceImpl technicienRepositoryServiceImpl;
	@Autowired
	AdresseRepository adresseRepository;
}
