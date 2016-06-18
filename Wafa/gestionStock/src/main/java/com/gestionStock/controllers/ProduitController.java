package com.gestionStock.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gestionStock.model.Produit;
import com.gestionStock.repositoryServiceImpl.ProduitRepositoryServiceImpl;

@RestController
@RequestMapping("/produit")
public class ProduitController {
	@RequestMapping(value = "/tousLesProduits", method = RequestMethod.GET)
	public Iterable<Produit> tousLesProduits() {
		return produitRepositoryServiceImpl.findAll();
	}
	
	@Autowired
	ProduitRepositoryServiceImpl produitRepositoryServiceImpl;
}
