package com.gestionStock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.gestionStock.model.Technicien;

public interface TechnicienRepository extends JpaRepository<Technicien, Long>{

}
