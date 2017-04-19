package test.br.com.caelum.leilao.servico;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;
import br.com.caelum.leilao.servico.Avaliador;

public class AvaliadorTest {

	private static final double PRECISAO = 0.00001;

	@Test
	public void deveEntenderLancesEmOrdemCrescente() {
		//parte cenario
		Usuario joao = new Usuario("Joao");
		Usuario jose = new Usuario("Jose");
		Usuario maria = new Usuario("Maria");
		
		Leilao leilao = new Leilao("Playstation 3 Novo");
		
		leilao.propoe(new Lance(joao, 200.00));
		leilao.propoe(new Lance(jose, 300.00));
		leilao.propoe(new Lance(maria, 400.00));
		
		//parte acao
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);

		double menorEsperado = 200.00;
		double maiorEsperado = 400.00;
		double medioEsperado = 300.00;
		
		assertEquals(menorEsperado, leiloeiro.getMenorLance(), PRECISAO);
		assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), PRECISAO);
		assertEquals(medioEsperado, leiloeiro.getMedio(), PRECISAO);
	}
	
	@Test
	public void deveEntenderLeilaoComApenasUmLance() {
		Usuario usuario = new Usuario("Joao");
		Leilao leilao = new Leilao("Playstation 4");
		
		leilao.propoe(new Lance(usuario, 1000));
		
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		assertEquals(1000, leiloeiro.getMaiorLance(), PRECISAO);
		assertEquals(1000, leiloeiro.getMenorLance(), PRECISAO);
		
	}
	
	@Test
	public void deveEntenderLancesEmOrdemAleatoria() {
		//parte cenario
		Usuario joao = new Usuario("Joao");
		Usuario jose = new Usuario("Jose");
		Usuario pedro = new Usuario("Pedro");
		Usuario batista = new Usuario("Batista");
		Usuario geremias = new Usuario("Geremias");
		Usuario maria = new Usuario("Maria");
		
		Leilao leilao = new Leilao("Playstation 2 Novo");

		leilao.propoe(new Lance(joao, 200.00));
		leilao.propoe(new Lance(jose, 450.00));
		leilao.propoe(new Lance(maria, 120.00));
		leilao.propoe(new Lance(pedro, 700.00));
		leilao.propoe(new Lance(batista, 630.00));
		leilao.propoe(new Lance(geremias, 230.00));
		
		//parte acao
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);

		List<Lance> maiores = leiloeiro.getTresMaiores();
		
		assertEquals(120, leiloeiro.getMenorLance(), PRECISAO);
		assertEquals(700, leiloeiro.getMaiorLance(), PRECISAO);
		assertEquals(388.3333333333, leiloeiro.getMedio(), PRECISAO);
		
        assertEquals(3, maiores.size());
        assertEquals(700, maiores.get(0).getValor(), PRECISAO);
        assertEquals(630, maiores.get(1).getValor(), PRECISAO);
        assertEquals(450, maiores.get(2).getValor(), PRECISAO);		
	}	
	
	@Test
	public void deveEntenderLancesEmOrdemDecrescente() {
		//parte cenario
		Usuario joao = new Usuario("Joao");
		Usuario jose = new Usuario("Jose");
		Usuario maria = new Usuario("Maria");
		Usuario carla = new Usuario("Carla");
		
		Leilao leilao = new Leilao("Playstation 3 Novo");
		
		leilao.propoe(new Lance(maria, 400.00));
		leilao.propoe(new Lance(jose, 300.00));
		leilao.propoe(new Lance(joao, 200.00));
		leilao.propoe(new Lance(carla, 100.00));
		
		//parte acao
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);

		
		assertEquals(100, leiloeiro.getMenorLance(), PRECISAO);
		assertEquals(400, leiloeiro.getMaiorLance(), PRECISAO);
		assertEquals(250, leiloeiro.getMedio(), PRECISAO);
	}
	
	@Test
    public void deveEncontrarOsTresMaioresLances() {
        Usuario joao = new Usuario("João");
        Usuario maria = new Usuario("Maria");
        Leilao leilao = new Leilao("Playstation 3 Novo");

        leilao.propoe(new Lance(joao, 100.0));
        leilao.propoe(new Lance(maria, 200.0));
        leilao.propoe(new Lance(joao, 300.0));
        leilao.propoe(new Lance(maria, 400.0));

        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        List<Lance> maiores = leiloeiro.getTresMaiores();

        assertEquals(3, maiores.size());
        assertEquals(400, maiores.get(0).getValor(), PRECISAO);
        assertEquals(300, maiores.get(1).getValor(), PRECISAO);
        assertEquals(200, maiores.get(2).getValor(), PRECISAO);
    }
	
	@Test
    public void deveDevolverTodosLancesCasoNaoHajaNoMinimo3() {
        Usuario joao = new Usuario("João");
        Usuario maria = new Usuario("Maria");
        Leilao leilao = new Leilao("Playstation 3 Novo");

        leilao.propoe(new Lance(joao, 100.0));
        leilao.propoe(new Lance(maria, 200.0));

        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        List<Lance> maiores = leiloeiro.getTresMaiores();

        assertEquals(2, maiores.size());
        assertEquals(200, maiores.get(0).getValor(), PRECISAO);
        assertEquals(100, maiores.get(1).getValor(), PRECISAO);
    }	
	
	@Test
    public void deveDevolverListaVaziaCasoNaoHajaLances() {
        Leilao leilao = new Leilao("Playstation 3 Novo");

        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        List<Lance> maiores = leiloeiro.getTresMaiores();

        assertEquals(0, maiores.size());
    }	
	
	
}
