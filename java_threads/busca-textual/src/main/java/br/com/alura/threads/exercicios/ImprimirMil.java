package br.com.alura.threads.exercicios;

public class ImprimirMil implements Runnable {

	public void run() {
		Thread atual = Thread.currentThread();
		for(int i =1; i < 1000;i++) {
			System.out.println("Numero " + i + "ID Thread " + atual.getId() );
		}

	}

}
