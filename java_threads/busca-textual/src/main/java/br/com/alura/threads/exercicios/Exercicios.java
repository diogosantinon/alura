package br.com.alura.threads.exercicios;

public class Exercicios {

	public static void main(String[] args) {
		exercicio7();

	}

	private static void exercicio7() {
		ImprimirMil imprimir = new ImprimirMil();
		Thread t1 = new Thread(imprimir);
		Thread t2 = new Thread(imprimir);
		
		t1.start();
		t2.start();
		
	}

}
