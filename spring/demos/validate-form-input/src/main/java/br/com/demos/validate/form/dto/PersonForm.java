package br.com.demos.validate.form.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonForm {

	@NotNull
	@Size(min=2, max=30)
	private String name;
	
	@NotNull
	@Min(18)
	private Integer age;
	
	
	
}
