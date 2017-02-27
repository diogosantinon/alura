package br.com.alura.threads.exercicios;

public class ImprimirString implements Runnable{

	private String texto;

	public ImprimirString(String texto) {
		this.texto = texto;
	}

	public void run() {
		System.out.println(this.texto);
	}
	
	
	
}
