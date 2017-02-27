package br.com.alura.threads.exercicios;

import java.io.File;

public class TarefaLerArquivosA implements Runnable {

	private File file1;
	private File file2;
	
	
	
	public TarefaLerArquivosA(File file1, File file2) {
		this.file1 = file1;
		this.file2 = file2;
	}



	public void run() {
		
		synchronized (file1) {
			System.out.println("Lendo Arquivo 1");
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			synchronized (file2) {
				System.out.println("Lendo Arquivo 2");
			}
		}
		
	}

}
