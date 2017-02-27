package br.com.alura.lista;

public class TarefaAdicionarElementos implements Runnable {

    private Lista lista;
    private int numeroDoThread;

    public TarefaAdicionarElementos(Lista lista, int numeroDoThread) {
        this.lista = lista;
        this.numeroDoThread = numeroDoThread;
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            lista.adicionaElementos("Thread " + numeroDoThread + " - " + i);
        }
    }

}
