package br.com.alura.banco;

import br.com.alura.banco.conta.ContaCorrente;
import br.com.alura.banco.conta.Tributavel;
import br.com.alura.banco.conta.ValorInvalidoException;

public class TestaTributavel {
    public static void main(String[] args) {
        ContaCorrente cc = new ContaCorrente();
        try {
			cc.deposita(100);
		} catch (ValorInvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println(cc.calculaTributos());

        // testando polimorfismo:
        Tributavel t = cc;
        System.out.println(t.calculaTributos());
    }	
}
