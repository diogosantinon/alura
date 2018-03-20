package br.com.demos.neo4j.entity;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@NodeEntity
public class Person {

	@GraphId private Long id;
	
	private String name;
	

	public Person(String name) {
		this.name = name;
	}
	
	@Relationship(type = "TEAMMATE", direction = Relationship.UNDIRECTED)
	public Set<Person> teammates;

	public void worksWith(Person person) {
		if (teammates == null) {
			teammates = new HashSet<>();
		}
		teammates.add(person);
	}

	public String toString() {

		return this.name + "'s teammates => "
				+ Optional.ofNullable(this.teammates).orElse(
						Collections.emptySet()).stream().map(
								person -> person.getName()).collect(Collectors.toList());
	}
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Set<Person> getTeammates() {
		return teammates;
	}
}
