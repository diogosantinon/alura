package br.com.alura.banco;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

import br.com.alura.banco.conta.Conta;
import br.com.alura.banco.conta.ContaPoupanca;

public class TestaOrdenacao {

	public static void main(String[] args) {
		System.out.println("Iniciando...");
		long inicio = System.currentTimeMillis();
		List<ContaPoupanca> contas = new ArrayList<ContaPoupanca>();
		ContaPoupanca ca = criarConta("A");
		contas.add(ca);
		ContaPoupanca cc = criarConta("C");
		contas.add(cc);
		ContaPoupanca cb = criarConta("B");
		contas.add(cb);
		int total = 30000;
//		for(int i = 0; i <= total; i++) {
//			ContaPoupanca a = criarConta("A"+i);
//			contas.add(a);
//		}
//		for (int i = 0; i < total; i++) {
//            contas.contains(i);
//        }		
		
//		Collections.sort(contas);
//        for (ContaPoupanca conta : contas) {
//            System.out.println(conta);
//        }		
//        System.out.println(contas);
        long fim = System.currentTimeMillis();
        long tempo = fim - inicio;
        System.out.println("Tempo gasto: " + tempo);
        
		HashSet<Conta> hash = new HashSet<>();
		Conta a = criarConta("A1");
		hash.add(a);
		for(int i = 0; i <= total; i++) {
			ContaPoupanca ba = criarConta("A"+i);
			hash.add(ba);
		}
		for (Conta conta : hash) {
          System.out.println(conta);
		}
//		
//		TreeSet<Integer> numeros = new TreeSet<>();
//		int Low = 10;
//		int High = 1000;
//		Random r = new Random();
//		for(int i=0; i <= 1000; i++) {
//			numeros.add(r.nextInt(High-Low) + Low);
//		}
//		Iterator<Integer> numero = numeros.descendingIterator();
//		while (numero.hasNext()) {
//			System.out.println(numero.next());
//			
//		}
		
		List<Integer> inteiros = new ArrayList<>();
		for(int i =0; i<=1000; i++) {
			inteiros.add(i);
		}
		Collections.sort(inteiros, Collections.reverseOrder());
		for (Integer integer : inteiros) {
			System.out.println(integer);
			
		}
	}
	private static ContaPoupanca criarConta(String nome) {
		ContaPoupanca a = new ContaPoupanca();
		Random random = new Random();
		a.setNome(nome);
		a.setNumero(1);
		a.setSaldo(random.nextInt(10000) + random.nextDouble()*100);
		return a;
	}

}
