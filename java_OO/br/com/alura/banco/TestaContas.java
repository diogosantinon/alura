package br.com.alura.banco;

import java.util.HashSet;

import br.com.alura.banco.conta.Conta;
import br.com.alura.banco.conta.ContaCorrente;
import br.com.alura.banco.conta.ContaPoupanca;
import br.com.alura.banco.conta.SaldoInsuficienteException;
import br.com.alura.banco.conta.ValorInvalidoException;
import br.com.alura.banco.sistema.AtualizadorDeContas;

public class TestaContas {
	public static void main(String[] args) {
		ContaCorrente cc = new ContaCorrente();
		ContaPoupanca cp = new ContaPoupanca();

		try {
			cc.deposita(1000);
			cp.deposita(1000);
		} catch (ValorInvalidoException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		cc.atualiza(0.01);
		cp.atualiza(0.01);

		System.out.printf("O saldo é: %.2f\n", cc.getSaldo());
		
		System.out.printf("O saldo é: %.2f\n", cp.getSaldo());
		

		cc = new ContaCorrente();
		cp = new ContaPoupanca();

		try {
			cc.deposita(1000);
			cp.deposita(1000);
		} catch (ValorInvalidoException e1) {
			e1.getMessage();
		}

		AtualizadorDeContas adc = new AtualizadorDeContas(0.01);

		adc.roda(cc);
		adc.roda(cp);

		System.out.println("Saldo Total: " + adc.getSaldoTotal());
		
		try {
	        cc.saca(10000);
	    } catch (SaldoInsuficienteException e) {
	        System.out.println(e.getMessage());
	    }
		
		try {
			cc.deposita(-100);
		} catch (ValorInvalidoException e) {
			System.out.println(e.getMessage());
		}
		
	}
}