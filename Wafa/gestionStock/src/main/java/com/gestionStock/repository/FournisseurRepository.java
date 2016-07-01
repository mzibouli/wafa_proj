package com.gestionStock.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.gestionStock.model.Adresse;
import com.gestionStock.model.Fournisseur;

public interface FournisseurRepository extends CrudRepository<Fournisseur, Long> {
	List<Fournisseur> findByEmail(String email);

	Fournisseur findByNomEntreprise(String nom);
	
	List<Fournisseur>  findByNomEntrepriseLike(String nom);
	List<Fournisseur>  findByNomEntrepriseContains(String nom);

	List<Fournisseur> findByTel(String tel);

	List<Fournisseur> findByAdresse(Adresse adresse);

	Iterable<Fournisseur> findAll();
	Iterable<Fournisseur> findAllByOrderByIdAsc();
	Iterable<Fournisseur> findAllByOrderByIdDesc();
}
