package br.com.alura.testes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class OrdenaStringsV2 {

	public static void main(String[] args) {
		ordenaStrings();
		ordenaStringsJava8();
		ordenaStringsConsumerInterfaceFuncional();
		ordenaStringsComparatorComparing();
		ordenaStringsMethodReferenceComparatorComparing();
		
		imprimeStringConsumersAsDefaultMethods();
		imprimeStringLambdaInterfaceFuncional();
		imprimeStringLambdaInterfaceFuncionalSimplificada();
		imprimeStringMethodReference();
		
	}

	private static void ordenaStringsMethodReferenceComparatorComparing() {
		List<String> palavras = criarListaStrings();
		
		palavras.sort(Comparator.comparing(String::length));
	}

	private static void ordenaStringsComparatorComparing() {
		List<String> palavras = criarListaStrings();
		
		palavras.sort(Comparator.comparing(s -> s.length()));
	}

	private static void imprimeStringMethodReference() {
		List<String> palavras = criarListaStrings();
		palavras.forEach(System.out::println);
	}

	private static void ordenaStringsConsumerInterfaceFuncional() {
		List<String> palavras = criarListaStrings();
		
		palavras.sort((s1, s2) -> {
			return Integer.compare(s1.length(), s2.length());
		});
		
	}

	private static void imprimeStringLambdaInterfaceFuncionalSimplificada() {
		List<String> palavras = criarListaStrings();
		
		palavras.forEach(s -> System.out.println(s));		
	}

	private static void imprimeStringLambdaInterfaceFuncional() {
		List<String> palavras = criarListaStrings();
		
		palavras.forEach((String s) -> {
			System.out.println(s);
		});
		
	}

	private static void imprimeStringConsumersAsDefaultMethods() {
		List<String> palavras = criarListaStrings();
		
		Consumer<String> consumidor = new ConsumidorDeString();
		palavras.forEach(consumidor);
	}

	private static void ordenaStringsJava8() {
		List<String> palavras = criarListaStrings();
		
		Comparator<String> comparator = new ComparadorDeStringPorTamanho();
		
		palavras.sort(comparator);
		System.out.println(palavras);
	}

	private static void ordenaStrings() {
		List<String> palavras = criarListaStrings();
		
		Collections.sort(palavras);
		System.out.println(palavras);
		
		Comparator<String> comparator = new ComparadorDeStringPorTamanho();
		Collections.sort(palavras, comparator);
		
		System.out.println(palavras);
	}

	private static List<String> criarListaStrings() {
		List<String> palavras = new ArrayList<>();
		palavras.add("teste 1");
		palavras.add("alura 232");
		palavras.add("taquara 3");
		return palavras;
	}
	
}
