package br.com.erudio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.dto.v1.PersonDTO;
import br.com.erudio.services.PersonService;

@RestController
@RequestMapping("/api/person/v1")
public class PersonController {

	@Autowired
	private PersonService service;

	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public List<PersonDTO> findAll() {

		return service.findAll();

	}

	@GetMapping(value = "/{id}", 
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public PersonDTO findById(@PathVariable(value = "id") Long id) {

		return service.findById(id);

	}
	
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, 
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@ResponseStatus(code = HttpStatus.CREATED)
	public PersonDTO create(@RequestBody PersonDTO person) {

		return service.create(person);

	}
	
	@PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, 
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public PersonDTO update(@RequestBody PersonDTO person) {

		return service.update(person);

	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {

		service.delete(id);
		
		return ResponseEntity.noContent().build();
	}

}
