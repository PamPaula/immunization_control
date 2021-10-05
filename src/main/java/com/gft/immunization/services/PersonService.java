package com.gft.immunization.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gft.immunization.entities.Person;
import com.gft.immunization.repositories.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;
	
	public Person savePerson(Person person) {
		
		return personRepository.save(person);
		
	}

	public List<Person> listPerson(String cpf) {

		if(cpf != null)
			return listPersonByCpf(cpf);
		
		return listAllPerson();
	}
	
	public List<Person> listAllPerson() {
		
		return personRepository.findAll();
		
	}

	private List<Person> listPersonByCpf(String cpf) {
		
		return personRepository.findByCpfContains(cpf);
		
	}
	
	public Person obtainPerson(Long id) throws Exception {
		
		Optional<Person> person = personRepository.findById(id);
		
		if(person.isEmpty()) {
			throw new Exception("Pessoa não encontrada!");
		}
		
		return person.get();
		
	}
	
	public void delPerson(Long id) {

		personRepository.deleteById(id);
		
	}

}
