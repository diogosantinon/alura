package br.com.alura.banheiro;

public class Banheiro {

	private boolean ehSujo = true;

	public void fazNumero1() {
		String nome = Thread.currentThread().getName();

		System.out.println(nome + " batendo na porta");

		// torna unica a execucao,
		synchronized (this) {

			System.out.println(nome + " entrando no banheiro");

			while (this.ehSujo) {
				esperarLaFora(nome);
			}

			System.out.println(nome + " fazendo coisa rapida");

			dormeUmPouco(5000);
			
			this.ehSujo = true;


			System.out.println(nome + " dando descarga");
			System.out.println(nome + " lavando a mao");
			System.out.println(nome + " saindo do banheiro");
		}
	}

	private void esperarLaFora(String nome) {
		System.out.println(nome + ", eca, banheiro td sujo");
		try {
			this.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void fazNumero2() {
		String nome = Thread.currentThread().getName();

		System.out.println(nome + " batendo na porta");

		synchronized (this) {

			System.out.println(nome + " entrando no banheiro");

			while (this.ehSujo) {
				esperarLaFora(nome);
			}

			System.out.println(nome + " fazendo coisa demorada");
			

			dormeUmPouco(10000);

			this.ehSujo = true;

			System.out.println(nome + " dando descarga");
			System.out.println(nome + " lavando a mao");
			System.out.println(nome + " saindo do banheiro");
		}
	}

	private void dormeUmPouco(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void limpa() {

	    String nome = Thread.currentThread().getName();

	    System.out.println(nome + " batendo na porta");

	    synchronized (this) {

	        System.out.println(nome + " entrando no banheiro");

	        if (!this.ehSujo) {
	            System.out.println(nome + ", não está sujo, vou sair");
	            return;
	        }

	        System.out.println(nome + " limpando o banheiro");
	        this.ehSujo = false;

	        dormeUmPouco(8000);

	        this.notifyAll();

	        System.out.println(nome + " saindo do banheiro");
	    }
	}

}
