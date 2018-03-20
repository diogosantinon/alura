package br.com.demos.neo4j.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.demos.neo4j.entity.Person;
import br.com.demos.neo4j.service.PersonService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/neo")
public class Neo4fController {

	@Autowired
	private PersonService personService;

	@GetMapping
	public String getTeammates(@RequestParam(value="name") final String name) {
		log.info("Finding team mates of ..{} ", name);
		return personService.getTeamMates(name);
	}
	
	@PostMapping("/save")
	public Person savePerson(@RequestBody final String namePerson) {
		log.info("saving person ... {} ", namePerson);
		return personService.savePerson(namePerson);
	}
}
