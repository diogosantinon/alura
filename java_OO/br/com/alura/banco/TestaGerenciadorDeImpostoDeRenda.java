package br.com.alura.banco;

import br.com.alura.banco.conta.ContaCorrente;
import br.com.alura.banco.conta.SeguroDeVida;
import br.com.alura.banco.conta.ValorInvalidoException;
import br.com.alura.banco.sistema.GerenciadorDeImpostoDeRenda;

public class TestaGerenciadorDeImpostoDeRenda {
    public static void main(String[] args) {

        GerenciadorDeImpostoDeRenda gerenciador = 
                    new GerenciadorDeImpostoDeRenda();

        SeguroDeVida sv = new SeguroDeVida();
        gerenciador.adiciona(sv);

        ContaCorrente cc = new ContaCorrente();
        try {
			cc.deposita(1000);
		} catch (ValorInvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        gerenciador.adiciona(cc);

        System.out.println(gerenciador.getTotal());
    }	

}
