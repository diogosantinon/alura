package br.com.alura.collections;

import java.util.ArrayList;
import java.util.Collection;

public class TestaPerformance {

	public static void main(String[] args) {
		Collection<Integer> numeros = new ArrayList<Integer>();
//		Collection<Integer> numeros = new HashSet<>();

        long inicio = System.currentTimeMillis();

        for (int i = 1; i <= 50000; i++) {
            numeros.add(i);
        }
        long fim = System.currentTimeMillis();

        long tempoDeExecucao = fim - inicio;
        System.out.println("Tempo gasto: " + tempoDeExecucao);
        inicio = System.currentTimeMillis();
        for (Integer numero : numeros) {
            numeros.contains(numero);
        }
        fim = System.currentTimeMillis();
        tempoDeExecucao = fim - inicio;
        System.out.println("Tempo gasto: " + tempoDeExecucao);


	}

}
