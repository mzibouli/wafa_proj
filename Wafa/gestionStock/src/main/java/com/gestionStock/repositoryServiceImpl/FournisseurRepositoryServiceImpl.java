package com.gestionStock.repositoryServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.gestionStock.model.Fournisseur;
import com.gestionStock.repository.FournisseurRepository;

@Service
@Configurable
@ComponentScan("com.gestionStock.repositoryServiceImpl")
public class FournisseurRepositoryServiceImpl implements FournisseurRepository {

	@Autowired
	private FournisseurRepository fournisseurRepository;
	
	@Override
	public long count() {
		return fournisseurRepository.count();
	}

	@Override
	public void delete(Long arg0) {
		fournisseurRepository.delete(arg0);
	}

	@Override
	public void delete(Fournisseur arg0) {
		fournisseurRepository.delete(arg0);		
	}

	@Override
	public void delete(Iterable<? extends Fournisseur> arg0) {
		fournisseurRepository.delete(arg0);		
	}

	@Override
	public void deleteAll() {
		fournisseurRepository.deleteAll();		
	}

	@Override
	public boolean exists(Long arg0) {
		return fournisseurRepository.exists(arg0);
	}

	@Override
	public Iterable<Fournisseur> findAll() {
		return fournisseurRepository.findAll();
	}

	@Override
	public Iterable<Fournisseur> findAll(Iterable<Long> arg0) {
		return fournisseurRepository.findAll(arg0);
	}

	@Override
	public Fournisseur findOne(Long arg0) {
		return fournisseurRepository.findOne(arg0);
	}

	@Override
	public <S extends Fournisseur> S save(S arg0) {
		return fournisseurRepository.save(arg0);
	}

	@Override
	public <S extends Fournisseur> Iterable<S> save(Iterable<S> arg0) {
		return fournisseurRepository.save(arg0);
	}

}
