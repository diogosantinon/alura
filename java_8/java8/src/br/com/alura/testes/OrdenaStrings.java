package br.com.alura.testes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class OrdenaStrings {
	public static void main(String[] args) {
		List<String> palavras = new ArrayList<>();
		palavras.add("alura online");
		palavras.add("casa do código");
		palavras.add("caelum");
		Comparator<String> comparador = new ComparadorDeStringPorTamanho();
		//modo antigo
//		Collections.sort(palavras, comparador);
		//modo java8
		palavras.sort(comparador);
		System.out.println(palavras);
		//classe anonima
		palavras.sort(new Comparator<String>() {
		    public int compare(String s1, String s2) {
		        if (s1.length() < s2.length())
		            return -1;
		        if (s1.length() > s2.length())
		            return 1;
		        return 0;
		    }
		});
		//lambda
		palavras.sort((s1, s2) -> {
		    if (s1.length() < s2.length())
		        return -1;
		    if (s1.length() > s2.length())
		        return 1;
		    return 0;
		});
		//
		palavras.sort((s1, s2) -> {
		    return Integer.compare(s1.length(), s2.length());
		});
		//
		palavras.sort(String.CASE_INSENSITIVE_ORDER);
		//
		palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
		//mais enxuto
		palavras.sort(Comparator.comparing(s -> s.length()));
		//ou method reference
		palavras.sort(Comparator.comparing(String::length));
		//ou
		Function<String, Integer> funcao = new Function<String, Integer>() {

			@Override
			public Integer apply(String s) {
				return s.length();
			}
		};
		Comparator<String> compara = Comparator.comparing(funcao);
		palavras.sort(compara);
		//modo antigo
//		for (String string : palavras) {
//			System.out.println(string);
//		}
		
		//modo java8 
		Consumer<String> consumidor = new ImprimeNaLina();
		palavras.forEach(consumidor);
		//ou classe anonima
		palavras.forEach(new Consumer<String>() {
		    public void accept(String s) {
		        System.out.println(s);
		    }
		});
		//ou lambda
		palavras.forEach((String s) -> {
		    System.out.println(s);
		});
		//
		palavras.forEach((s) -> {
		    System.out.println(s);
		});
		//
		palavras.forEach(s -> {
		    System.out.println(s);
		});
		//
		palavras.forEach(s -> System.out.println(s));
		//method reference
		Consumer<String> impressor = System.out::println;
		palavras.forEach(impressor);
		
		testeThread();
	}
	
	private static void testeThread() {
		new Thread(new Runnable() {

		    @Override
		    public void run() {
		        System.out.println("Executando um Runnable");
		    }

		}).start();
		
		new Thread(() -> System.out.println("Executando dois Runnable")).start();
	}
}

class ImprimeNaLina implements Consumer<String> {

	@Override
	public void accept(String t) {
		System.out.println(t);
		
	}
	
}
