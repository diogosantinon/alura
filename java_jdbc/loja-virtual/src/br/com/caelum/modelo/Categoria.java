package br.com.caelum.modelo;

import java.util.ArrayList;
import java.util.List;

public class Categoria {

	private final Integer id;
	private final String nome;
    private final List<Produto> produtos = new ArrayList<>();
    
	public Categoria(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	public String getNome() {
		return this.nome;
	}
	public Integer getId() {
		return this.id;
	}
	
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void adiciona(Produto p) {
		produtos.add(p);
	}
	
	
	
}
