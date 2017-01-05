package br.com.alura.banco.conta;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Banco {
	private List<Conta> contas;
	private Map<String, Conta> mapaContas  = new HashMap<>(); 

	public List<Conta> getContas() {
		return contas;
	}

	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}
	
	public void adiciona(Conta c) {
		contas.add(c);
		mapaContas.put(c.getNome(), c);
	}
	
	public Conta pega(int x) {
		return contas.get(x);
	}
	
	public int pegaQuantidadeDeContas() {
		return contas.size();
	}
	
	public Conta buscaPorNome(String nome) {
		return mapaContas.get(nome);
	}
	
}
