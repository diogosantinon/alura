package br.com.alura.servidor_tarefas.servidor;

import java.io.PrintStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class JuntaResultadosFeatures implements Callable<Void> {

	private Future<String> futureWS;
	private Future<String> futureBanco;
	private PrintStream saidaCliente;

	public JuntaResultadosFeatures(Future<String> futureWS, Future<String> futureBanco, PrintStream saidaCliente) {
		this.futureWS = futureWS;
		this.futureBanco = futureBanco;
		this.saidaCliente = saidaCliente;
	}

	@Override
	public Void call()  {
		System.out.println("Aguardando Resultados do future WS  e banco ");
		
		try {
			String numeroMagico = this.futureWS.get(5, TimeUnit.SECONDS);
			String numeroMagico2 = this.futureBanco.get(5, TimeUnit.SECONDS);
			
			this.saidaCliente.println("Resultado do C2: " + numeroMagico + ", " + numeroMagico2);
			
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			System.out.println("Timeout: Cancelando execucao do comando C2 ");
			this.saidaCliente.println("Timeout comando c2");
			this.futureBanco.cancel(true);
			this.futureWS.cancel(true);
			
		}
		
		System.out.println("Finalizando JuntaResultadosFeatures");
		
		return null;
	}

}
