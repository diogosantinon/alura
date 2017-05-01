package br.com.caelum.leilao.builder;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;

public class CriadorDeLeilao {

	private Leilao leilao;
	
	public CriadorDeLeilao() {
	}

	public CriadorDeLeilao para(String descricaoLeilao) {
		leilao = new Leilao(descricaoLeilao);
		return this;
	}

	public CriadorDeLeilao lance(Usuario usuario, double valor) {
		leilao.propoe(new Lance(usuario, valor));
		return this;
	}

	public Leilao constroi() {
		return this.leilao;
	}
	
	

}
