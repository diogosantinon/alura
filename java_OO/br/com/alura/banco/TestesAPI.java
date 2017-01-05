package br.com.alura.banco;

import java.io.PrintStream;

import br.com.alura.banco.conta.Conta;
import br.com.alura.banco.conta.ContaCorrente;

public class TestesAPI {

	public static void main(String[] args) {
	    PrintStream saida = System.out;
	    saida.println("ola");
	    
	    Conta conta = new ContaCorrente();
	    System.out.println(conta);
	    
	    Conta cc = new ContaCorrente();
	    cc.setNumero(1);
	    cc.setNome("AA");
	    Conta cd = new ContaCorrente();
	    cd.setNumero(1);
	    cd.setNome("AV");
	    
	    if(cc == cd) {
	    	System.out.println("==");
	    }
	    if (cc.equals(cd)) {
	    	System.out.println("equals");
	    }
	    
	    String nome = "Alura";
	    for (int i= 0; i < nome.length(); i++ ) {
			System.out.println(nome.charAt(i));
		}
	    
	    nome = "Socorram-me, subi no ônibus em Marrocos";
	    for (int i = (nome.length() -1); i >= 0 ; i-- ) {
			System.out.println(nome.charAt(i));
		}	    
	    
	    String[] palavras = nome.split(" ");
	    for (int i = palavras.length -1; i >= 0; i--) {
	    	System.out.println(palavras[i]);
	    }
	    
	    StringBuilder frase = new StringBuilder();
	    frase.append("Socorram-me, subi no ônibus em Marrocos");
	    frase = frase.reverse();
	    System.out.println(frase);
	    
        String numero = "762";
        System.out.println("Imprimindo a string: " + numero);

        int resultado = getNumber(numero);
        System.out.println("Imprimindo o int: " + resultado);
    }

	private static int getNumber(String number) {
	    int result = 0;
	    for (int i = 0; i < number.length(); i++) {
	        result = result * 10 + number.charAt(i) - '0';
	    }
	    return result;
	}    
	    
}
