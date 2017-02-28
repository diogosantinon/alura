package br.com.alura.servidor_tarefas.exercicios;

import java.util.Set;

public class Exercicios {

	public static void main(String[] args) {
		exercicio213();
	}

	private static void exercicio213() {
		Set<Thread> todasAsThreads = Thread.getAllStackTraces().keySet();

		for (Thread thread : todasAsThreads) {
		    System.out.println(thread.getName());
		}
		
		Runtime runtime = Runtime.getRuntime();
		int qtdProcessadores = runtime.availableProcessors();
		System.out.println("Qtd de processadores: " + qtdProcessadores);		
	}

}
