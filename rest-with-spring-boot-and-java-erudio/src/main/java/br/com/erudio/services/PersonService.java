package br.com.erudio.services;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.erudio.model.Person;

@Service
public class PersonService {
	
	private final AtomicLong counter = new AtomicLong();
	
	private Logger logger = Logger.getLogger(PersonService.class.getName());
		
	public Person findById(String id) {
		
		logger.info("Fiding one person!");
		
		Person person = new Person();
		
		person.setId(counter.incrementAndGet());
		person.setFirstName("Guilherme");
		person.setLastName("Nascimento");
		person.setAddress("Duque de Caxias - Rio de Janeiro - Brasil");
		person.setGender("Male");
		
		return person;
	}

}
