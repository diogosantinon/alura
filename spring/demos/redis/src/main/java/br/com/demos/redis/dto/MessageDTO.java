package br.com.demos.redis.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MessageDTO implements Serializable{

	private static final long serialVersionUID = -917863990874612258L;
	private final String message;
}
