package br.com.alura.lista;

public class Principal {

    public static void main(String[] args) throws InterruptedException {

        Lista lista = new Lista();
//    	List<String> lista = new ArrayList<String>();
//      List<String> lista = new Vector<String>(); //thread-safe possui syncronized no metodo de add
//		Set conjunto = Collections.synchronizedSet(new HashSet());//set nao possui thread-safe mas podemos usar o collections
        
        //criando 10 thread e inicializando
        for(int i = 0; i<10; i++) {
            new Thread(new TarefaAdicionarElementos(lista, i)).start();
        }

        //dorme por 2s
//        Thread.sleep(5000);

        //imprimindo a nossa lista
//        for (int i = 0; i < lista.tamanho(); i++) {
//            System.out.println(i + " - " + lista.pegaElemento(i));
//        }
        new Thread(new TarefaImprimir(lista)).start();
    }

}
