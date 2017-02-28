package br.com.alura.servidor_tarefas.cliente;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClienteTarefas {

    public static void main(String[] args) throws Exception {
        final Socket socket = new Socket("localhost", 12345);
        System.out.println("Conexão Estabelecida");
        
        Thread threadEnviaComando = new Thread(new Runnable() {

            public void run() {

                try {
                    System.out.println("Pode enviar comandos!");
                    PrintStream saida = new PrintStream(socket.getOutputStream());

                    Scanner teclado = new Scanner(System.in);
                    while (teclado.hasNextLine()) {

                        String linha = teclado.nextLine();

                        if (linha.trim().equals("")) {
                            break;
                        }

                        saida.println(linha);
                    }

                    saida.close();
                    teclado.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        
        Thread threadRecebeResposta = new Thread(new Runnable() {

            public void run() {

                try {
                    System.out.println("Recebendo dados do servidor");
                    Scanner respostaServidor = new Scanner(socket.getInputStream());

                    while (respostaServidor.hasNextLine()) {
                        String linha = respostaServidor.nextLine();
                        System.out.println(linha);
                    }

                    respostaServidor.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });        

        threadRecebeResposta.start();
        threadEnviaComando.start();
        //thread main vai esperar ate a outra thread terminar
        threadEnviaComando.join();
        
//        thread.join(30000); Isso significa que vamos esperar 30s para se "juntar" a outra thread. 
        //Depois dos 30s continuaremos, mesmo se a outra thread não tiver finalizado ainda.
        
        //java 8
        //new Thread( () -> { System.out.println("rodando");} ).start();

        System.out.println("Fechando o socket do cliente");
        socket.close();
    }

}
