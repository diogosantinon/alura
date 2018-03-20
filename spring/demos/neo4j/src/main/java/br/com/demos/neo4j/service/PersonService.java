package br.com.demos.neo4j.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.demos.neo4j.entity.Person;
import br.com.demos.neo4j.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PersonService {
	
	@Autowired
	private PersonRepository repository;
	
	public String getTeamMates(String name) {
		log.info("finding team mates of person {}...", name);
		final Person person = repository.findByName(name);
		return person.getTeammates().toString();
	}

	public Person savePerson(String namePerson) {
		log.info("saving person {}...", namePerson);
		final Person newPerson = new Person(namePerson);
		return repository.save(newPerson);
	}

	
}
