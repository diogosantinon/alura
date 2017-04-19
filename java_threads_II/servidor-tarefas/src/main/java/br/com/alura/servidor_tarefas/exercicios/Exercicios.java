package br.com.alura.servidor_tarefas.exercicios;

import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Exercicios {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		exercicio213();
		futureTasks();
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
	
	private static void futureTasks() throws InterruptedException, ExecutionException {
		Callable<String> tarefa = new Tarefa(); //Tarefa implementa Callable
		FutureTask<String> futureTask = new FutureTask<String>(tarefa);
		new Thread(futureTask).start(); //usando Thread puro!!            
		String resultado = futureTask.get();
		System.out.println(resultado);
	}

}
