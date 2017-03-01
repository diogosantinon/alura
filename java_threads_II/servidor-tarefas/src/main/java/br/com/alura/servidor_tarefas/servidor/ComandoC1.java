package br.com.alura.servidor_tarefas.servidor;

import java.io.PrintStream;

public class ComandoC1 implements Runnable {

	private PrintStream saidaCliente;

	public ComandoC1(PrintStream saidaCliente) {
		this.saidaCliente = saidaCliente;
	}

	public void run() {
        System.out.println("Executando comando c1");

        try {
            // faz algo bem demorado
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //devolvendo resposta para o cliente
        saidaCliente.println("Comando c1 executado com sucesso!");
	}

}
