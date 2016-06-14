package com.gestionStock.repositoryServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.gestionStock.model.Produit;
import com.gestionStock.repository.FournisseurRepository;
import com.gestionStock.repository.ProduitRepository;

@Service
@Configurable
@ComponentScan("com.gestionStock.repositoryServiceImpl")
public class ProduitRepositoryServiceImpl implements ProduitRepository {

	@Autowired
	private ProduitRepository produitRepository;
	
	@Override
	public long count() {
		return produitRepository.count();
	}

	@Override
	public void delete(Long arg0) {
		produitRepository.delete(arg0);
	}

	@Override
	public void delete(Produit arg0) {
		produitRepository.delete(arg0);
	}

	@Override
	public void delete(Iterable<? extends Produit> arg0) {
		produitRepository.delete(arg0);
	}

	@Override
	public void deleteAll() {
		produitRepository.deleteAll();
	}

	@Override
	public boolean exists(Long arg0) {
		return produitRepository.exists(arg0);
	}

	@Override
	public Iterable<Produit> findAll() {
		return produitRepository.findAll();
	}

	@Override
	public Iterable<Produit> findAll(Iterable<Long> arg0) {
		return produitRepository.findAll(arg0);
	}

	@Override
	public Produit findOne(Long arg0) {
		return produitRepository.findOne(arg0);
	}

	@Override
	public <S extends Produit> S save(S arg0) {
		return produitRepository.save(arg0);
	}

	@Override
	public <S extends Produit> Iterable<S> save(Iterable<S> arg0) {
		return produitRepository.save(arg0);
	}

}
