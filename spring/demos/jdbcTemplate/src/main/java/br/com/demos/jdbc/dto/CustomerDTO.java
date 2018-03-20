package br.com.demos.jdbc.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CustomerDTO implements Serializable{
	
	private static final long serialVersionUID = -6399364600477965046L;

	private final String firstName;
	private final String lastName;
}
