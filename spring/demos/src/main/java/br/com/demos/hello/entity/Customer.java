package br.com.demos.hello.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customer {

	private long id;
	private String firstName, lastName;
}
