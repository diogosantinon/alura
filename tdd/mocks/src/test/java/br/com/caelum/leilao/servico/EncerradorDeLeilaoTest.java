package br.com.caelum.leilao.servico;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.caelum.leilao.builder.CriadorDeLeilao;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.infra.dao.RepositorioDeLeiloes;

@RunWith(MockitoJUnitRunner.class)
public class EncerradorDeLeilaoTest {

	@InjectMocks
	EncerradorDeLeilao encerradorDeLeilao;
	@Mock
	RepositorioDeLeiloes repositorio;

	@Mock
	EnviadorDeEmail email;

	@Before
	public void setUp() {
		encerradorDeLeilao = new EncerradorDeLeilao(repositorio, email);
	}

	@Test
	public void deveEncerrarLeilaoQueComecaramUmaSemanaAtras() {
		Calendar antiga = Calendar.getInstance();
		antiga.set(1999, 1, 20);
		Leilao leilao1 = new CriadorDeLeilao().para("TV de plasma").naData(antiga).constroi();
		Leilao leilao2 = new CriadorDeLeilao().para("Geladeira").naData(antiga).constroi();
		List<Leilao> leiloesAntigos = Arrays.asList(leilao1, leilao2);

		when(repositorio.correntes()).thenReturn(leiloesAntigos);

		encerradorDeLeilao.encerra();

		assertTrue(leilao1.isEncerrado());
		assertTrue(leilao2.isEncerrado());
		assertEquals(2, encerradorDeLeilao.getTotalEncerrados());

	}

	@Test
	public void naoDeveEncerrarLeilaoComecaramOntem() {
		Calendar ontem = Calendar.getInstance();
		ontem.add(Calendar.DATE, -1);
		Leilao leilao1 = new CriadorDeLeilao().para("TV de plasma").naData(ontem).constroi();
		Leilao leilao2 = new CriadorDeLeilao().para("Geladeira").naData(ontem).constroi();
		List<Leilao> leiloesAntigos = Arrays.asList(leilao1, leilao2);
		when(repositorio.correntes()).thenReturn(leiloesAntigos);
		encerradorDeLeilao.encerra();

		assertFalse(leilao1.isEncerrado());
		assertFalse(leilao2.isEncerrado());
		assertEquals(0, encerradorDeLeilao.getTotalEncerrados());

	}

	@Test
	public void deveFazerNadaNenhumLeilao() {
		RepositorioDeLeiloes dao = mock(RepositorioDeLeiloes.class);
		when(dao.correntes()).thenReturn(new ArrayList<Leilao>());
		encerradorDeLeilao.encerra();
		assertEquals(0, encerradorDeLeilao.getTotalEncerrados());

	}

	@Test
	public void deveAtualizarLeiloesEncerrados() {
		Calendar antiga = Calendar.getInstance();
		antiga.set(1988, 2, 12);

		Leilao leilao = new CriadorDeLeilao().para("TV").naData(antiga).constroi();
		when(repositorio.correntes()).thenReturn(Arrays.asList(leilao));

		encerradorDeLeilao.encerra();

		verify(repositorio, times(1)).atualiza(leilao);
	}

	@Test
	public void deveAtualizarEnviarEmailLeiloesEncerrados() {
		Calendar antiga = Calendar.getInstance();
		antiga.set(1988, 2, 12);

		Leilao leilao = new CriadorDeLeilao().para("TV").naData(antiga).constroi();
		when(repositorio.correntes()).thenReturn(Arrays.asList(leilao));

		encerradorDeLeilao.encerra();

		InOrder inOrder = inOrder(repositorio, email);
		inOrder.verify(repositorio, times(1)).atualiza(leilao);
		inOrder.verify(email, times(1)).envia(leilao);

	}

	@Test
	public void naoDeveEncerrarLeiloesQueComecaramMenosDeUmaSemanaAtras() {

		Calendar ontem = Calendar.getInstance();
		ontem.add(Calendar.DAY_OF_MONTH, -3);

		Leilao leilao1 = new CriadorDeLeilao().para("TV de plasma").naData(ontem).constroi();
		Leilao leilao2 = new CriadorDeLeilao().para("Geladeira").naData(ontem).constroi();

		when(repositorio.correntes()).thenReturn(Arrays.asList(leilao1, leilao2));

		encerradorDeLeilao.encerra();

		assertEquals(0, encerradorDeLeilao.getTotalEncerrados());
		assertFalse(leilao1.isEncerrado());
		assertFalse(leilao2.isEncerrado());

		verify(repositorio, never()).atualiza(leilao1);
		verify(repositorio, never()).atualiza(leilao2);
	}

	@Test
	public void deveContinuarAExecucaoQdoDAOFalha() {
		Calendar antiga = Calendar.getInstance();
		antiga.set(1999, 1, 30);

		Leilao leilao1 = new CriadorDeLeilao().para("TV de plasma").naData(antiga).constroi();
		Leilao leilao2 = new CriadorDeLeilao().para("Geladeira").naData(antiga).constroi();

		when(repositorio.correntes()).thenReturn(Arrays.asList(leilao1, leilao2));
		
		doThrow(new RuntimeException()).when(repositorio).atualiza(leilao1);
		
		encerradorDeLeilao.encerra();
		
		verify(repositorio, times(1)).atualiza(leilao2);
		verify(email, times(1)).envia(leilao2);
		verify(email, never()).envia(leilao1);
		

	}
	
	@Test
	public void deveContinuarAExecucaoQdoEmailFalha() {
		Calendar antiga = Calendar.getInstance();
		antiga.set(1999, 1, 30);

		Leilao leilao1 = new CriadorDeLeilao().para("TV de plasma").naData(antiga).constroi();
		Leilao leilao2 = new CriadorDeLeilao().para("Geladeira").naData(antiga).constroi();

		when(repositorio.correntes()).thenReturn(Arrays.asList(leilao1, leilao2));
		
		doThrow(new RuntimeException()).when(email).envia(leilao1);
//		doThrow(new Exception()).when(email).envia(leilao1);
		
		encerradorDeLeilao.encerra();
		
		verify(repositorio, times(1)).atualiza(leilao1);
		verify(repositorio, times(1)).atualiza(leilao2);
		verify(email, times(1)).envia(leilao2);

	}
	
	@Test
	public void naoDeveChamarEmailParaDAOFalha() {
		Calendar antiga = Calendar.getInstance();
		antiga.set(1999, 1, 30);

		Leilao leilao1 = new CriadorDeLeilao().para("TV de plasma").naData(antiga).constroi();
		Leilao leilao2 = new CriadorDeLeilao().para("Geladeira").naData(antiga).constroi();

		when(repositorio.correntes()).thenReturn(Arrays.asList(leilao1, leilao2));
		
		doThrow(new RuntimeException()).when(repositorio).atualiza(any(Leilao.class));
//		doThrow(new Exception()).when(email).envia(leilao1);
		
		encerradorDeLeilao.encerra();
		
		verify(email, never()).envia(any(Leilao.class));

	}		

}
