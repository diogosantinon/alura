package br.com.alura.banco;

import java.util.HashMap;
import java.util.Map;

import br.com.alura.banco.conta.Conta;
import br.com.alura.banco.conta.ContaCorrente;
import br.com.alura.banco.conta.ValorInvalidoException;

public class TestaMapa {
	public static void main(String[] args) throws ValorInvalidoException {
        Conta c1 = new ContaCorrente();
        c1.deposita(10000);

        Conta c2 = new ContaCorrente();
        c2.deposita(3000);

        // cria o mapa
        Map<String, Conta> mapaDeContas = new HashMap<String, Conta>();

        // adiciona duas chaves e seus valores
        mapaDeContas.put("diretor", c1);
        mapaDeContas.put("gerente", c2);

        // qual a conta do diretor?
        Conta contaDoDiretor = mapaDeContas.get("diretor");
        System.out.println(contaDoDiretor.getSaldo());
    }
}
