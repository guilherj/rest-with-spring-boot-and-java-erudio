package br.com.erudio.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.erudio.dto.v1.PersonDTO;
import br.com.erudio.exceptions.ResourceNotFoundException;
import br.com.erudio.repositories.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository repository;

	private Logger logger = Logger.getLogger(PersonService.class.getName());

	
	public List<PersonDTO> findAll() {

		logger.info("Fiding all people!");

		return repository.findAll();
	}

	public PersonDTO findById(Long id) {

		logger.info("Fiding one person!");
		

		return repository.findById(id).orElseThrow(() -> 
		new ResourceNotFoundException("No records found for this ID!"));
	}

	public PersonDTO create(PersonDTO person) {

		logger.info("Creating one person!");

		return repository.save(person);
	}

	public PersonDTO update(PersonDTO person) {

		logger.info("Updating one person!");
		
		var entity = repository.findById(person.getId()).orElseThrow(() -> 
		new ResourceNotFoundException("No records found for this ID!"));
		
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());

		return repository.save(entity);
	}

	public void delete(Long id) {

		logger.info("Deleting one person!");
		
		var entity = repository.findById(id).orElseThrow(() -> 
		new ResourceNotFoundException("No records found for this ID!"));
		
		repository.delete(entity);

	}

}
