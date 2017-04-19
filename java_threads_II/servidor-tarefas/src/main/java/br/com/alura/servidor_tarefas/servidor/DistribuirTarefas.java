package br.com.alura.servidor_tarefas.servidor;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class DistribuirTarefas implements Runnable {

    private Socket socket;
    private ServidorTarefas servidor;
	private ExecutorService threadPool;
	private BlockingQueue<String> filaComandos;

    public DistribuirTarefas(ExecutorService threadPool, BlockingQueue<String> filaComandos, Socket socket, ServidorTarefas servidor) {
        this.threadPool = threadPool;
		this.socket = socket;
        this.servidor = servidor;
		this.filaComandos = filaComandos; 
    }
	
	
    public void run() {

        try {
            System.out.println("Distribuindo as tarefas para o cliente " + socket);

            Scanner entradaCliente = new Scanner(socket.getInputStream());
            PrintStream saidaCliente = new PrintStream(socket.getOutputStream());

            while (entradaCliente.hasNextLine()) {

                String comando = entradaCliente.nextLine();
                System.out.println("Comando recebido " + comando);

                switch (comando) {
                    case "c1": {
                        // confirmação do o cliente
                        saidaCliente.println("Confirmação do comando c1");
                        ComandoC1 c1 = new ComandoC1(saidaCliente);
                        this.threadPool.execute(c1);
                        break;
                    }
                    case "c2": {
                        saidaCliente.println("Confirmação do comando c2");
                        ComandoC2ChamaWS c2ws = new ComandoC2ChamaWS(saidaCliente);
                        ComandoC2AcessaBanco c2banco =  new ComandoC2AcessaBanco(saidaCliente);
                        Future<String> futureWS = this.threadPool.submit(c2ws);
                        Future<String> futureBanco = this.threadPool.submit(c2banco);
                        
                        this.threadPool.submit(new JuntaResultadosFeatures(futureWS, futureBanco, saidaCliente));
                        
                        break;
                    }
                    case "c3" : {
                    	this.filaComandos.put(comando);
                    	saidaCliente.println("Comando C3 add na fila");
                    	break;
                    }
                    case "fim" : {
                        saidaCliente.println("Desligando o servidor");
                        servidor.parar();
                        return;
                    }                    
                    default: {
                        saidaCliente.println("Comando não encontrado");
                    }
                }

//                System.out.println(comando);
            }

            saidaCliente.close();
            entradaCliente.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
