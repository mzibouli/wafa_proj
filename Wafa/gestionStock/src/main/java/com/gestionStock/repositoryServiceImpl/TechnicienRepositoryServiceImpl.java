package com.gestionStock.repositoryServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.gestionStock.model.Technicien;
import com.gestionStock.repository.ProduitRepository;
import com.gestionStock.repository.TechnicienRepository;
import com.gestionStock.repository.TechnicienRepositoryOriginal;

@Service
@Configurable
@ComponentScan("com.gestionStock.repositoryServiceImpl")
public class TechnicienRepositoryServiceImpl{

	@Autowired
	private TechnicienRepository technicienRepository;
	
	public Iterable<Technicien> getAllTechniciens(){
		return technicienRepository.findAll();
	}
	
	public void addTechniciens(Technicien technicien){
		technicienRepository.save(technicien);
		
	}
	
	
	
}
