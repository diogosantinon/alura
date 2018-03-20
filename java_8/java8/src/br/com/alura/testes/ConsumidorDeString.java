package br.com.alura.testes;

import java.util.function.Consumer;

public class ConsumidorDeString implements Consumer<String> {

	@Override
	public void accept(String t) {
		System.out.println(t);
	}
	

}
