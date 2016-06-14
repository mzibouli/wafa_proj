package com.gestionStock.repository;

import org.springframework.data.repository.CrudRepository;

import com.gestionStock.model.Produit;

public interface ProduitRepository extends CrudRepository<Produit, Long> {

}
