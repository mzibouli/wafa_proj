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
import com.gestionStock.model.Client;
import com.gestionStock.model.Produit;
import com.gestionStock.repository.AdresseRepository;
import com.gestionStock.repositoryServiceImpl.ClientRepositoryServiceImpl;
import com.gestionStock.util.ClientAdresse;

/**
 * Class ClientController
 */
@RestController
@RequestMapping("/client")
public class ClientController {

	@RequestMapping(value = "/tousLesClients", method = { RequestMethod.GET })
	@ResponseBody
	public Iterable<Client> tousLesClient() {
		return clientRepositoryServiceImpl.findAll();
	}

	@RequestMapping(value = "/creerClient", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public ClientAdresse creerClient(@RequestBody String jsonClientAdresse) {
		ObjectMapper mapper = new ObjectMapper();
		Client client = null;
		ClientAdresse clientAdresse = null;
		Adresse adresse = null;
		try {
			clientAdresse = mapper.readValue(jsonClientAdresse, ClientAdresse.class);
			client = clientAdresse.getClient();
			client.setNom(client.getNom().toUpperCase());
			client.setPrenom(client.getPrenom().toUpperCase());
			adresse = clientAdresse.getAdresse();
			client.setAdresse(adresse);
			if (adresse != null) {
				adresseRepository.save(adresse);
			}

			clientRepositoryServiceImpl.save(client);
		} catch (JsonGenerationException e) {

			e.printStackTrace();

		} catch (JsonMappingException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
		return clientAdresse;
	}

	@Autowired
	ClientRepositoryServiceImpl clientRepositoryServiceImpl;
	@Autowired
	AdresseRepository adresseRepository;

}
