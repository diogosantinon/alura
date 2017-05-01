package br.com.caelum.leilao.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leilao {

	private static final int MAXIMO_LANCES_USUARIO = 5;
	private String descricao;
	private List<Lance> lances;
	
	public Leilao(String descricao) {
		this.descricao = descricao;
		this.lances = new ArrayList<Lance>();
	}
	
	public void propoe(Lance lance) {
		
		if(this.getLances().isEmpty() || permiteLance(lance)) {
			lances.add(lance);
		}
		
	}

	private boolean permiteLance(Lance lance) {
		return !getUltimoLance().getUsuario().equals(lance.getUsuario())
				&& qtdLancesDo(lance.getUsuario()) < MAXIMO_LANCES_USUARIO;
	}

	private int qtdLancesDo(Usuario usuario) {
		int count = 0;
		for (Lance lance : this.getLances()) {
			if(lance.getUsuario().equals(usuario)) {
				count++;
			}
		}
		return count;
	}

	private Lance getUltimoLance() {
		return this.getLances().get(this.getLances().size() -1);
	}

	public String getDescricao() {
		return descricao;
	}

	public List<Lance> getLances() {
		return Collections.unmodifiableList(lances);
	}

	public void dobraLance(Usuario usuario) {
		Lance ultimo = getUltimoLanceDo(usuario);
		if(ultimo != null) {
			propoe(new Lance(usuario, ultimo.getValor()*2));
		}
		
	}

	private Lance getUltimoLanceDo(Usuario usuario) {
		int count = this.getLances().size() - 1;
		Lance lance = null;
		while (count > -1) {
			if(this.getLances().get(count).getUsuario().equals(usuario)) {
				lance = this.getLances().get(count);
				break;
			}
			count--;
		}
		return lance;
	}

	
	
}
