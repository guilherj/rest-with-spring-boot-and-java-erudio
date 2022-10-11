package br.com.erudio.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.erudio.model.Person;

@Service
public class PersonService {

	private final AtomicLong counter = new AtomicLong();

	private Logger logger = Logger.getLogger(PersonService.class.getName());

	public Person create(Person person) {

		logger.info("Creating one person!");

		return person;
	}

	public Person update(Person person) {

		logger.info("Updating one person!");

		return person;
	}
	
	public void delete(String id) {

		logger.info("Deleting one person!");

	}

	public List<Person> findAll() {

		List<Person> persons = new ArrayList<>();

		logger.info("Fiding all people!");

		for (int i = 0; i < 8; i++) {

			Person person = mockPerson(i);
			persons.add(person);
		}

		return persons;
	}

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

	private Person mockPerson(int i) {

		Person person = new Person();

		person.setId(counter.incrementAndGet());
		person.setFirstName("Person" + i);
		person.setLastName("LastName" + i);
		person.setAddress("Brasil");
		person.setGender("Male");

		return person;
	}

}
