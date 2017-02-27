package br.com.alura.banheiro;

public class TarefaLimpeza implements Runnable {

    private Banheiro banheiro;

    public TarefaLimpeza(Banheiro banheiro) {
        this.banheiro = banheiro;
    }

    public void run() {
    	while(true) {
            this.banheiro.limpa();
            try {
                Thread.sleep(1000);//limpando cada 15s
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
