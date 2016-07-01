package com.gestionStock.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.gestionStock.model.Client;

public interface ClientRepository extends CrudRepository<Client, Long> {



}
