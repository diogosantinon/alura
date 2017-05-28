package br.com.caelum.leilao.servico;

import java.util.Calendar;
import java.util.List;

import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Pagamento;
import br.com.caelum.leilao.infra.dao.RepositorioDeLeiloes;
import br.com.caelum.leilao.infra.dao.RepositorioDePagamentos;
import br.com.caelum.leilao.infra.sistema.Relogio;
import br.com.caelum.leilao.infra.sistema.RelogioDoSistema;

public class GeradorDePagamento {

	private RepositorioDeLeiloes repositorioDeLeiloes;
	private RepositorioDePagamentos repositorioDePagamentos;
	private Avaliador avaliador;
	private Relogio relogio;

	public GeradorDePagamento(RepositorioDeLeiloes repositorioDeLeiloes, 
				RepositorioDePagamentos repositorioDePagamentos,
				Avaliador avaliador, 
				Relogio relogio) {
					this.repositorioDeLeiloes = repositorioDeLeiloes;
					this.repositorioDePagamentos = repositorioDePagamentos;
					this.avaliador = avaliador;
					this.relogio = relogio;
	}
	
	public GeradorDePagamento(RepositorioDeLeiloes repositorioDeLeiloes, 
			RepositorioDePagamentos repositorioDePagamentos,
			Avaliador avaliador) {
				this(repositorioDeLeiloes, repositorioDePagamentos, avaliador, new RelogioDoSistema());
}	
	
	public void gera() {
		List<Leilao> leiloesEncerrados = repositorioDeLeiloes.encerrados();
		
		for (Leilao leilao : leiloesEncerrados) {
			
			avaliador.avalia(leilao);
			Pagamento novoPagamento = new Pagamento(avaliador.getMaiorLance(), primeiroDiaUtil());
			repositorioDePagamentos.salva(novoPagamento);
		}
	}

	private Calendar primeiroDiaUtil() {
		Calendar data = relogio.hoje();
		int diaSemana = data.get(Calendar.DAY_OF_WEEK);
		
		if(diaSemana == Calendar.SATURDAY) {
			data.add(Calendar.DAY_OF_MONTH, 2);
		} else if(diaSemana == Calendar.SUNDAY) {
			data.add(Calendar.DAY_OF_MONTH, 1);
		}
		return data;
	}
	
	
}
