package br.com.alura.servidor_tarefas.servidor;

import java.io.PrintStream;

public class ComandoC2 implements Runnable {

	private PrintStream saidaCliente;

	public ComandoC2(PrintStream saidaCliente) {
		this.saidaCliente = saidaCliente;
	}

	public void run() {
        System.out.println("Executando comando c2");

        try {
            // faz algo bem demorado
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        throw new RuntimeException("exception no comando C2");
        //devolvendo resposta para o cliente
//        saidaCliente.println("Comando c2 executado com sucesso!");
	}

}
