package br.com.alura.threads.exercicios;

import java.io.File;

public class Exercicios {
	
    public static File arquivo1 = new File("arquivo1.txt");
    public static File arquivo2 = new File("arquivo2.txt");
	
	public static void main(String[] args) {
		exercicio9();
		exercicio13();
		exericioDeadLock();
	}
	
	private static void exericioDeadLock() {
		new Thread(new TarefaLerArquivosA(arquivo1, arquivo2)).start();
		new Thread(new TarefaLerArquivosB(arquivo1, arquivo2)).start();
		
	}

	private static void exercicio9() {
		ImprimirString imprimir = new ImprimirString("texto para imprimir");
		Thread t1 = new Thread(imprimir, "Thread exercicio 9");
		t1.start();
	}
	
	private static void exercicio13() {
        new Thread(new Runnable() {
            public void run() {
                System.out.println("resposta");
            }
        }).start();
	}

}
