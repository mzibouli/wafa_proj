package com.gestionStock.controllers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gestionStock.model.Fournisseur;
import com.gestionStock.model.Produit;
import com.gestionStock.repositoryServiceImpl.FournisseurRepositoryServiceImpl;
import com.gestionStock.repositoryServiceImpl.ProduitRepositoryServiceImpl;

@RestController
@RequestMapping("/produit")
public class ProduitController {
	@RequestMapping(value = "/tousLesProduits", method = RequestMethod.GET)
	public Iterable<Produit> tousLesProduits() {
		Iterable<Produit> produis = produitRepositoryServiceImpl.findAll();
		return produis;
	}

	@RequestMapping(value = "/ajouterProduit", method = RequestMethod.POST)
	@ResponseBody
	public Produit ajouterProduit(@RequestBody String jsonProduit) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			JsonNode nodeProduits = mapper.readValue(jsonProduit, JsonNode.class);
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			for (int i = 0; i < nodeProduits.size(); i++) {
				JsonNode nodeProduit = nodeProduits.get(i);
				String serialNumber = nodeProduit.get("serialNumber").asText();
				String description = nodeProduit.get("description").asText();
				String fabriquant = nodeProduit.get("fabriquant").asText();
				Date dateAchat = formatter.parse(nodeProduit.get("dateAchat").asText());
				Produit prd = new Produit(serialNumber, description, fabriquant,  dateAchat);
				produitRepositoryServiceImpl.save(prd);
				String fournisseurName = nodeProduit.get("fournisseur").asText();
				Fournisseur four = fournisseurRepositoryServiceImpl.findByNomEntreprise(fournisseurName);
				four.getProduits().add(prd);
				fournisseurRepositoryServiceImpl.save(four);
			
			}
		} catch (JsonGenerationException e) {

			e.printStackTrace();

		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Autowired
	ProduitRepositoryServiceImpl produitRepositoryServiceImpl;
	@Autowired
	FournisseurRepositoryServiceImpl fournisseurRepositoryServiceImpl;
}
