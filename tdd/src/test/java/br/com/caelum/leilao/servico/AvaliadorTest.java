package br.com.caelum.leilao.servico;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.caelum.leilao.builder.CriadorDeLeilao;
import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;

public class AvaliadorTest {

	private static final double PRECISAO = 0.00001;
	private Avaliador leiloeiro;
	private Usuario maria;
	private Usuario jose;
	private Usuario joao;
	private Usuario geremias;
	private Usuario batista;
	private Usuario pedro;
	
	@Before
	public void setUp() {
		leiloeiro = new Avaliador();
		joao = new Usuario("Joao");
		jose = new Usuario("Jose");
		maria = new Usuario("Maria");
		batista = new Usuario("Batista");
		geremias = new Usuario("Geremias");
		pedro = new Usuario("Geremias");
	}

	@Test
	public void deveEntenderLancesEmOrdemCrescente() {
		//parte cenario
		Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo")
				.lance(joao, 200)
				.lance(jose, 300)
				.lance(maria, 400)
				.constroi();
		
		//parte acao
		
		leiloeiro.avalia(leilao);

		double menorEsperado = 200.00;
		double maiorEsperado = 400.00;
		double medioEsperado = 300.00;
		
		assertEquals(menorEsperado, leiloeiro.getMenorLance(), PRECISAO);
		assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), PRECISAO);
		assertEquals(medioEsperado, leiloeiro.getMedio(), PRECISAO);
		
		//com hamcrest
		assertThat(leiloeiro.getMenorLance(), equalTo(menorEsperado));
		assertThat(leiloeiro.getMaiorLance(), equalTo(maiorEsperado));
		assertThat(leiloeiro.getMedio(), equalTo(medioEsperado));
		
	}
	
	@Test
	public void deveEntenderLeilaoComApenasUmLance() {
		
		Leilao leilao = new CriadorDeLeilao().para("Playstation 4")
				.lance(joao, 1000)
				.constroi();		
		
		leiloeiro.avalia(leilao);
		
		assertEquals(1000, leiloeiro.getMaiorLance(), PRECISAO);
		assertEquals(1000, leiloeiro.getMenorLance(), PRECISAO);
		
		//hamcrest
		assertThat(leiloeiro.getMenorLance(), equalTo(1000.00));
		assertThat(leiloeiro.getMaiorLance(), equalTo(1000.00));
		
		
	}
	
	@Test
	public void deveEntenderLancesEmOrdemAleatoria() {
		//parte cenario
		
		Leilao leilao = new CriadorDeLeilao().para("Playstation 2 Novo")
				.lance(joao, 200)
				.lance(jose, 450.00)
				.lance(maria, 120.00)
				.lance(pedro, 700.00)
				.lance(batista, 630.00)
				.lance(geremias, 230.00)				
				.constroi();		
		
		//parte acao
		leiloeiro.avalia(leilao);

		List<Lance> maiores = leiloeiro.getTresMaiores();
		
		assertEquals(120, leiloeiro.getMenorLance(), PRECISAO);
		assertEquals(700, leiloeiro.getMaiorLance(), PRECISAO);
		assertEquals(388.3333333333, leiloeiro.getMedio(), PRECISAO);
		
        assertEquals(3, maiores.size());
        assertEquals(700, maiores.get(0).getValor(), PRECISAO);
        assertEquals(630, maiores.get(1).getValor(), PRECISAO);
        assertEquals(450, maiores.get(2).getValor(), PRECISAO);
        
        //hamcrest
		assertThat(leiloeiro.getMenorLance(), equalTo(120.00));
		assertThat(leiloeiro.getMaiorLance(), equalTo(700.00));
		assertThat(leiloeiro.getMedio(), equalTo(388.3333333333333));
        
		assertThat(maiores, hasSize(3));
		assertThat(maiores, hasItems(
                new Lance(pedro, 700),
                new Lance(batista, 630),
                new Lance(jose, 450)
        ));
        
	}	
	
	@Test
	public void deveEntenderLancesEmOrdemDecrescente() {
		
		Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo")
				.lance(maria, 400)
				.lance(jose, 300.00)
				.lance(joao, 200.00)
				.lance(geremias, 100.00)
				.constroi();
		
		//parte acao
		leiloeiro.avalia(leilao);

		assertEquals(100, leiloeiro.getMenorLance(), PRECISAO);
		assertEquals(400, leiloeiro.getMaiorLance(), PRECISAO);
		assertEquals(250, leiloeiro.getMedio(), PRECISAO);
	}
	
	@Test
    public void deveEncontrarOsTresMaioresLances() {
		Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo")
				.lance(joao, 100.00)
				.lance(maria, 200)
				.lance(joao, 300.00)
				.lance(maria, 400.00)
				.constroi();

        leiloeiro.avalia(leilao);

        List<Lance> maiores = leiloeiro.getTresMaiores();

        assertEquals(3, maiores.size());
        assertEquals(400, maiores.get(0).getValor(), PRECISAO);
        assertEquals(300, maiores.get(1).getValor(), PRECISAO);
        assertEquals(200, maiores.get(2).getValor(), PRECISAO);
    }
	
	@Test
    public void deveDevolverTodosLancesCasoNaoHajaNoMinimo3() {
		Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo")
				.lance(joao, 100.00)
				.lance(maria, 200)
				.constroi();

        leiloeiro.avalia(leilao);

        List<Lance> maiores = leiloeiro.getTresMaiores();
        //com Junit
        assertEquals(2, maiores.size());
        assertEquals(200, maiores.get(0).getValor(), PRECISAO);
        assertEquals(100, maiores.get(1).getValor(), PRECISAO);
        
        //com hamcrest
        assertThat(maiores.size(), equalTo(2));
        assertThat(maiores, hasItems(
                new Lance(joao, 100),
                new Lance(maria, 200)
        ));
    }	
	
	@Test
	public void naoDeveAvaliarLeiloesSemNenhumLanceDadoComTry() {
	    try {
	        Leilao leilao = new CriadorDeLeilao()
	            .para("Playstation 3 Novo")
	            .constroi();

	        leiloeiro.avalia(leilao);
	        fail();
	    }
	    catch(RuntimeException e) {
	        // deu certo!
	    }
	}	
	
	@Test(expected=RuntimeException.class)
	public void naoDeveAvaliarLeiloesSemNenhumLanceDado() {
		Leilao leilao = new CriadorDeLeilao().para("Camiseta").constroi();
		leiloeiro.avalia(leilao);
	}
	
	@After
	public void finaliza() {
	  System.out.println("fim");
	}	
	
	@BeforeClass
	public static void testandoBeforeClass() {
	  System.out.println("before class");
	}

	@AfterClass
	public static void testandoAfterClass() {
	  System.out.println("after class");
	}
	
}
