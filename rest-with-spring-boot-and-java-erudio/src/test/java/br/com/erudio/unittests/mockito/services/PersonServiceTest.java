package br.com.erudio.unittests.mockito.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.stereotype.Repository;

import br.com.erudio.model.Person;
import br.com.erudio.repositories.PersonRepository;
import br.com.erudio.services.PersonService;
import br.com.erudio.unittests.mapper.mocks.MockPerson;

@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class PersonServiceTest {
	
	MockPerson input;
	
	@InjectMocks
	private PersonService service;
	
	@Mock
	private PersonRepository repository;
	

	@BeforeEach
	void setUpMocks() throws Exception {
		
		input = new MockPerson();
		
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	void testFindById() {
		
		Person person = input.mockEntity(1);
		person.setId(1L);
		
		/*
		 * Quando o repository.findById for chamado o mockito vai interceptar
		 * a chamada e retornará um optional do mock de person criado acima. 
		 * 
		 * PS.: Necessário colocar o PersonRepository com a notação @Mock como feito
		 * mais a cima.
		 */
		when(repository.findById(1L)).thenReturn(Optional.of(person));
		
		var result = service.findById(1L);
		assertNotNull(result);
		assertNotNull(result.getKey());
		assertNotNull(result.getLinks());
		
		assertNotNull(result.toString().contains("links: [</api/person/v1/1>;rel=\"self\"]"));
		
		assertEquals("Addres Test1", result.getAddress());
		assertEquals("First Name Test1", result.getFirstName());
		assertEquals("Last Name Test1", result.getLastName());
		assertEquals("Female", result.getGender());
		
		
		
	}

	@Test
	void testFindAll() {
		fail("Not yet implemented");
	}
	

	@Test
	void testCreate() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	void testDelete() {
		fail("Not yet implemented");
	}

}