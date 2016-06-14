package com.gestionStock.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gestionStock.model.Technicien;
import com.gestionStock.repositoryServiceImpl.TechnicienRepositoryServiceImpl;

@RestController
@RequestMapping("/technicien")
public class TechnicienController {
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
public Iterable<Technicien> getAllTechniciens(){
	
	return technicienRepositoryServiceImpl.findAll();
	
}
	
	@Autowired
	TechnicienRepositoryServiceImpl technicienRepositoryServiceImpl;
}

