package com.gestionStock.repositoryServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.gestionStock.model.Adresse;
import com.gestionStock.repository.AdresseRepository;

@Service
@Configurable
@ComponentScan("com.gestionStock.repositoryServiceImpl")
public class AdresseRepositoryServiceImpl implements AdresseRepository{

	@Autowired
	private AdresseRepository adresseRepository;
	
	@Override
	public long count() {
		return adresseRepository.count();
	}

	@Override
	public void delete(Long arg0) {
		adresseRepository.delete(arg0);
	}

	@Override
	public void delete(Adresse arg0) {
		adresseRepository.delete(arg0);
	}

	@Override
	public void delete(Iterable<? extends Adresse> arg0) {
		adresseRepository.delete(arg0);
	}

	@Override
	public void deleteAll() {
		adresseRepository.deleteAll();
	}

	@Override
	public boolean exists(Long arg0) {
		return adresseRepository.exists(arg0);
	}

	@Override
	public Iterable<Adresse> findAll() {
		return adresseRepository.findAll();
	}

	@Override
	public Iterable<Adresse> findAll(Iterable<Long> arg0) {
		return adresseRepository.findAll(arg0);
	}

	@Override
	public Adresse findOne(Long arg0) {
		return adresseRepository.findOne(arg0);
	}

	@Override
	public <S extends Adresse> S save(S arg0) {
		return adresseRepository.save(arg0);
	}

	@Override
	public <S extends Adresse> Iterable<S> save(Iterable<S> arg0) {
		return adresseRepository.save(arg0);
	}

}
