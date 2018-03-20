package br.com.demos.neo4j.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.demos.neo4j.entity.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {

    Person findByName(String name);
}
