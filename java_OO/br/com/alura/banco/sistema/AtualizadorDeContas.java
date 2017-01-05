package br.com.alura.banco.sistema;

import br.com.alura.banco.conta.Conta;

public class AtualizadorDeContas {
    private double saldoTotal = 0;
    private double selic;

    public AtualizadorDeContas(double selic) {
        this.selic = selic;
    }

    public void roda(Conta c) {
        System.out.println(c.getSaldo());
        c.atualiza(this.selic);
        System.out.println(c.getSaldo());
        this.saldoTotal += c.getSaldo();
    }

    
    public void setSaldoTotal(double saldoTotal) {
        this.saldoTotal = saldoTotal;
    }

    public double getSaldoTotal() {
        return this.saldoTotal;
    }
}