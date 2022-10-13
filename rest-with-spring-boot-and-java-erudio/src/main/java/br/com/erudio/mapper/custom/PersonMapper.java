package br.com.erudio.mapper.custom;

import java.util.Date;

import org.springframework.stereotype.Service;

import br.com.erudio.dto.v2.PersonDTO;
import br.com.erudio.model.Person;

@Service
public class PersonMapper {
	
	public PersonDTO convertEntityToDTO(Person person) {
		
		PersonDTO dto = new PersonDTO();
		
		dto.setId(person.getId());
		dto.setAddress(person.getAddress());
		dto.setBirthDay(new Date());
		dto.setFirstName(person.getFirstName());
		dto.setGender(person.getGender());
		dto.setLastName(person.getLastName());
		
		return dto;
	}
	
public Person convertDTOToEntity(PersonDTO dto) {
		
		Person person = new Person();
		
		person.setId(dto.getId());
		person.setAddress(dto.getAddress());
		//person.setBirthDay(new Date());
		person.setFirstName(dto.getFirstName());
		person.setGender(dto.getGender());
		person.setLastName(dto.getLastName());
		
		return person;
	}

}
