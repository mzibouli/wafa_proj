package com.gestionStock.repositoryServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.gestionStock.model.Client;
import com.gestionStock.repository.ClientRepository;

@Service
@Configurable
@ComponentScan("com.gestionStock.repositoryServiceImpl")
public class ClientRepositoryServiceImpl implements ClientRepository {
	@Autowired
	private ClientRepository clientRepository;

	@Override
	public long count() {
		return clientRepository.count();
	}

	@Override
	public void delete(Long arg0) {
		clientRepository.delete(arg0);
	}

	@Override
	public void delete(Client arg0) {
		clientRepository.delete(arg0);	
	}

	@Override
	public void delete(Iterable<? extends Client> arg0) {
		clientRepository.delete(arg0);	
	}

	@Override
	public void deleteAll() {
		clientRepository.deleteAll();
	}

	@Override
	public boolean exists(Long arg0) {
		
		return clientRepository.exists(arg0);
	}

	@Override
	public Iterable<Client> findAll() {
		
		return clientRepository.findAll();
	}

	@Override
	public Iterable<Client> findAll(Iterable<Long> arg0) {
		
		return clientRepository.findAll(arg0);
	}

	@Override
	public Client findOne(Long arg0) {
		
		return clientRepository.findOne(arg0);
	}

	@Override
	public <S extends Client> S save(S arg0) {
		
		return clientRepository.save(arg0);
	}

	@Override
	public <S extends Client> Iterable<S> save(Iterable<S> arg0) {
		
		return clientRepository.save(arg0);
	}

}
