package br.com.caelum.leilao.dominio;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static br.com.caelum.leilao.dominio.matcher.LeilaoMatcher.*;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.leilao.builder.CriadorDeLeilao;

public class LanceTest {
	
	private Usuario usuario;

	@Before
	public void setUp() {
		usuario = new Usuario("A");
	}
	
	@Test
	public void deveConstruirLance() {
		double valor = 1;
		Lance lance = new Lance(usuario, valor);
		assertThat(lance.getValor(), equalTo(valor));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void naoDeveConstruirLanceParaValorNegativo() {
		double valor = -1;
		new Lance(usuario, valor);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void naoDeveConstruirLanceParaValorZero() {
		double valor = 0;
		new Lance(usuario, valor);
	}	
	
    @Test
    public void deveReceberUmLance() {
        Leilao leilao = new CriadorDeLeilao().para("Macbook Pro 15").constroi();
        assertEquals(0, leilao.getLances().size());

        Lance lance = new Lance(new Usuario("Steve Jobs"), 2000);
        leilao.propoe(lance);

        assertThat(leilao.getLances().size(), equalTo(1));
        assertThat(leilao, temUmLance(lance));
    }	

}
