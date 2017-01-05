package br.com.alura.banco.conta;

public class ContaPoupanca extends Conta implements Comparable<ContaPoupanca>{

	public void atualiza(double taxa) {
		this.saldo += this.saldo * taxa * 3;
	}

	@Override
	public void deposita(double valor) {
		this.saldo += valor - 0.10;
	}

	@Override
	public int compareTo(ContaPoupanca outra) {
		return this.getNome().compareTo(outra.getNome());

	}

}