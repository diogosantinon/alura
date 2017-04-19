package br.com.alura.servidor_tarefas.servidor;

import java.util.concurrent.BlockingQueue;

public class TarefaConsumir implements Runnable {

	private BlockingQueue<String> comandos;
	
	
	
	public TarefaConsumir(BlockingQueue<String> comandos) {
		this.comandos = comandos;
	}



	@Override
	public void run() {
		try {
			String comando = null;
			
			while ((comando = comandos.take()) != null) {
				System.out.println("Consumindo comando " + comando + ", " + Thread.currentThread().getName());
				
				Thread.sleep(10000);
				System.out.println("Comando C3 exetucado!!!");
			}
			
		} catch (InterruptedException e) {
			throw new RuntimeException(e); 
		}
	}

}
