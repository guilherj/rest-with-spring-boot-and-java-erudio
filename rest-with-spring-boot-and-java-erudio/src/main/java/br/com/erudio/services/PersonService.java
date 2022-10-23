package br.com.erudio.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import br.com.erudio.controllers.PersonController;
import br.com.erudio.dto.v1.PersonDTO;
import br.com.erudio.exceptions.ResourceNotFoundException;
import br.com.erudio.mapper.DozerMapper;
import br.com.erudio.model.Person;
import br.com.erudio.repositories.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository repository;

	private Logger logger = Logger.getLogger(PersonService.class.getName());

	
	public List<PersonDTO> findAll() {

		logger.info("Fiding all people!");

		var persons = DozerMapper.parseListObjects(repository.findAll(), PersonDTO.class);
		
		// Adicionando HATEOAS para o findById em cada elemento da lista
		persons.stream()
			   .forEach(p -> p.add(linkTo(methodOn(PersonController.class).findById(p.getKey())).withSelfRel()));
		
		return persons;
	}

	public PersonDTO findById(Long id) {

		logger.info("Fiding one person!");
		

		var entity =  repository.findById(id).orElseThrow(() -> 
		new ResourceNotFoundException("No records found for this ID!"));
		
		var dto = DozerMapper.parseObject(entity, PersonDTO.class);
		
		// Adicionando HATEOAS no objeto dto
		dto.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());
		
		return dto;
	}

	public PersonDTO create(PersonDTO person) {

		logger.info("Creating one person!");
		
		var entity = DozerMapper.parseObject(person, Person.class);
		
		var dto = DozerMapper.parseObject(repository.save(entity), PersonDTO.class);
		
		// Adicionando HATEOAS para o findById
		dto.add(linkTo(methodOn(PersonController.class).findById(dto.getKey())).withSelfRel());

		return dto;
	}

	public PersonDTO update(PersonDTO person) {

		logger.info("Updating one person!");
		
		var entity = repository.findById(person.getKey()).orElseThrow(() -> 
		new ResourceNotFoundException("No records found for this ID!"));
		
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());

		var dto = DozerMapper.parseObject(repository.save(entity), PersonDTO.class);
		
		// Adicionando HATEOAS para o findById
		dto.add(linkTo(methodOn(PersonController.class).findById(dto.getKey())).withSelfRel());

		return dto;
	}

	public void delete(Long id) {

		logger.info("Deleting one person!");
		
		var entity = repository.findById(id).orElseThrow(() -> 
		new ResourceNotFoundException("No records found for this ID!"));
		
		repository.delete(entity);

	}

}
