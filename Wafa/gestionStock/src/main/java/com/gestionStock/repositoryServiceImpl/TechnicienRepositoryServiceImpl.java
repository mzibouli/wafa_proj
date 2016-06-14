package com.gestionStock.repositoryServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.gestionStock.model.Technicien;
import com.gestionStock.repository.ProduitRepository;
import com.gestionStock.repository.TechnicienRepository;

@Service
@Configurable
@ComponentScan("com.gestionStock.repositoryServiceImpl")
public class TechnicienRepositoryServiceImpl implements TechnicienRepository{

	@Autowired
	private TechnicienRepository technicienRepository;
	
	@Override
	public long count() {
		return technicienRepository.count();
	}

	@Override
	public void delete(Long arg0) {
		technicienRepository.delete(arg0);		
	}

	@Override
	public void delete(Technicien arg0) {
		technicienRepository.delete(arg0);		
	}

	@Override
	public void delete(Iterable<? extends Technicien> arg0) {
		technicienRepository.delete(arg0);		
	}

	@Override
	public void deleteAll() {
		technicienRepository.deleteAll();		
	}

	@Override
	public boolean exists(Long arg0) {
		return technicienRepository.exists(arg0);
	}

	@Override
	public Iterable<Technicien> findAll() {
		return technicienRepository.findAll();
	}

	@Override
	public Iterable<Technicien> findAll(Iterable<Long> arg0) {
		return technicienRepository.findAll(arg0);
	}

	@Override
	public Technicien findOne(Long arg0) {
		return technicienRepository.findOne(arg0);
	}

	@Override
	public <S extends Technicien> S save(S arg0) {
		return technicienRepository.save(arg0);
	}

	@Override
	public <S extends Technicien> Iterable<S> save(Iterable<S> arg0) {
		return technicienRepository.save(arg0);
	}

}
