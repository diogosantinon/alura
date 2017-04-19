package br.com.alura.servidor_tarefas.servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicBoolean;

public class ServidorTarefas {
	
    private ServerSocket servidor;
    private ExecutorService threadPool;
    private AtomicBoolean estaRodando; //Threads fazem uma cópia da memória para a sua cache, Atomic evita o cache e acessa na memoria
    private BlockingQueue<String> filaComandos;
    
    public ServidorTarefas() throws IOException {
        System.out.println("---- Iniciando Servidor ----");
		servidor = new ServerSocket(12345);
//		ExecutorService threadPool = Executors.newSingleThreadExecutor();//unica thread
//		ExecutorService threadPool = Executors.newFixedThreadPool(2);//max 2 Threads
		//threadPool = Executors.newCachedThreadPool(); //aumenta dinamicamente
		ThreadFactory defaultFactory = Executors.defaultThreadFactory();
		threadPool = Executors.newCachedThreadPool(new FabricaDeThreads(defaultFactory));

		this.estaRodando = new AtomicBoolean(true);
		
		this.filaComandos = new ArrayBlockingQueue<>(2);
		
		inicializarConsumidores();
    }    
    
	private void inicializarConsumidores() {
		int qtdConsumidores = 2;
		for(int i=0; i < qtdConsumidores; i++) {
			TarefaConsumir tarefa = new TarefaConsumir(filaComandos);
			this.threadPool.execute(tarefa);
		}
		
	}

	private void rodar() throws IOException {
		  

        while (this.estaRodando.get()) { //usando o atributo
            try {
                Socket socket = this.servidor.accept();
                System.out.println("Aceitando novo cliente na porta " + socket.getPort());

                DistribuirTarefas distribuirTarefas = new DistribuirTarefas(threadPool, filaComandos, socket, this);

                this.threadPool.execute(distribuirTarefas);
            } catch (SocketException e) {
                System.out.println("SocketException, está rodando? " + this.estaRodando);
            }   
        }
    }    
    
    public void parar() throws IOException {
        this.estaRodando.set(false);
        this.threadPool.shutdown();
        this.servidor.close();        
    }    


    public static void main(String[] args) throws Exception {
        ServidorTarefas servidor = new ServidorTarefas();
        servidor.rodar();
    }    

}
