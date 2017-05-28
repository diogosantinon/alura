package br.com.caelum.leilao.servico;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import br.com.caelum.leilao.builder.CriadorDeLeilao;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Pagamento;
import br.com.caelum.leilao.dominio.Usuario;
import br.com.caelum.leilao.infra.dao.RepositorioDeLeiloes;
import br.com.caelum.leilao.infra.dao.RepositorioDePagamentos;
import br.com.caelum.leilao.infra.sistema.Relogio;

public class GeradorDePagamentoTest {

	private RepositorioDeLeiloes leiloes;
	private RepositorioDePagamentos pagamentos;
	private Avaliador avaliador;
	private Relogio relogio;

	@Before
	public void setUp() {
		leiloes = mock(RepositorioDeLeiloes.class);
		pagamentos = mock(RepositorioDePagamentos.class);
		avaliador = mock(Avaliador.class);
		relogio = mock(Relogio.class);
	}

	@Test
	public void deveGerarPagamentoParaUmLeilaoEncerrado() {
		Leilao leilao = new CriadorDeLeilao().para("Playstation").lance(new Usuario("José da Silva"), 2000.0)
				.lance(new Usuario("Maria Pereira"), 2500.0).constroi();

		when(leiloes.encerrados()).thenReturn(Arrays.asList(leilao));
		when(avaliador.getMaiorLance()).thenReturn(2500.0);

		GeradorDePagamento gerador = new GeradorDePagamento(leiloes, pagamentos, avaliador);
		gerador.gera();

		ArgumentCaptor<Pagamento> argumento = ArgumentCaptor.forClass(Pagamento.class);
		verify(pagamentos).salva(argumento.capture());

		assertThat(argumento.getValue().getValor(), equalTo(2500.0));
	}

	@Test
	public void deveEmpurrarParaOProximoDiaUtilSeForSabado() {
		Calendar sabado = Calendar.getInstance();
		sabado.set(2012, Calendar.APRIL, 7);

		when(relogio.hoje()).thenReturn(sabado);

		Leilao leilao = new CriadorDeLeilao().para("Playstation").lance(new Usuario("José da Silva"), 2000.0)
				.lance(new Usuario("Maria Pereira"), 2500.0).constroi();

		when(leiloes.encerrados()).thenReturn(Arrays.asList(leilao));

		GeradorDePagamento gerador = new GeradorDePagamento(leiloes, pagamentos, new Avaliador(), relogio);
		gerador.gera();

		ArgumentCaptor<Pagamento> argumento = ArgumentCaptor.forClass(Pagamento.class);
		verify(pagamentos).salva(argumento.capture());
		Pagamento pagamentoGerado = argumento.getValue();

		assertThat(pagamentoGerado.getData().get(Calendar.DAY_OF_WEEK), equalTo(Calendar.MONDAY));
		assertThat(pagamentoGerado.getData().get(Calendar.DAY_OF_MONTH), equalTo(9));

	}
	
	@Test
	public void deveEmpurrarParaOProximoDiaUtilSeForDomingo() {
		Calendar sabado = Calendar.getInstance();
		sabado.set(2012, Calendar.APRIL, 8);

		when(relogio.hoje()).thenReturn(sabado);

		Leilao leilao = new CriadorDeLeilao().para("Playstation").lance(new Usuario("José da Silva"), 2000.0)
				.lance(new Usuario("Maria Pereira"), 2500.0).constroi();

		when(leiloes.encerrados()).thenReturn(Arrays.asList(leilao));

		GeradorDePagamento gerador = new GeradorDePagamento(leiloes, pagamentos, new Avaliador(), relogio);
		gerador.gera();

		ArgumentCaptor<Pagamento> argumento = ArgumentCaptor.forClass(Pagamento.class);
		verify(pagamentos).salva(argumento.capture());
		Pagamento pagamentoGerado = argumento.getValue();

		assertThat(pagamentoGerado.getData().get(Calendar.DAY_OF_WEEK), equalTo(Calendar.MONDAY));
		assertThat(pagamentoGerado.getData().get(Calendar.DAY_OF_MONTH), equalTo(9));

	}

}
