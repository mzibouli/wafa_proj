package com.gestionStock.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gestionStock.model.Produit;
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
		Produit prd = new Produit();
		prd.setDescription("test");
		return produitRepositoryServiceImpl.save(prd);
	}
	
	
	
	
	
	
	@Autowired
	ProduitRepositoryServiceImpl produitRepositoryServiceImpl;
}
