package br.com.demos.neo4j.repository;

import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

import br.com.demos.neo4j.entity.Person;

@Repository
public interface PersonRepository extends GraphRepository<Person> {
	
	Person findByName(String name);

}
