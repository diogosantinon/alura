package br.com.alura.servidor_tarefas.exercicios;

import java.util.concurrent.Callable;

public class Tarefa implements Callable<String> {

	@Override
	public String call() throws Exception {
		
		return "Olá";
	}

}
