package br.com.alura.xml.model;

public class Produto {

	private String nome;
	private double preco;

	public Produto(String nome, double preco) {
		this.nome = nome;
		this.preco = preco;
				
	}

	public double getPreco() {
		return preco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	@Override
	public String toString() {
		return "Nome " + getNome() + "\n" + "Preço: " + getPreco() + "\n";
		
	}

}
