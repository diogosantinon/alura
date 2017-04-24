package br.com.caelum.leilao.dominio;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.leilao.builder.CriadorDeLeilao;

public class LeilaoTest {
	
	private Usuario usuario;
	private Usuario usuario2;

	@Before
	public void setUp() {
		usuario = new Usuario("A");
		usuario2 = new Usuario("B");
	}
	
	@Test
	public void deveReceberUmLance() {
		Leilao leilao = new CriadorDeLeilao().para("Leilao TV 50").constroi();
		assertEquals(0, leilao.getLances().size());
		
		Lance lance = new Lance(usuario, 1000);
		leilao.propoe(lance);
		assertEquals(1, leilao.getLances().size());
		assertEquals(1000, leilao.getLances().get(0).getValor(), 0.00001);
		
	}
	
	@Test
	public void deveReceberVariosLances() {
		Leilao leilao = new CriadorDeLeilao().
				para("Leilao TV 50")
				.lance(usuario, 1000)
				.lance(usuario2, 1200)
				.constroi();

		assertEquals(2, leilao.getLances().size());
		assertEquals(1000, leilao.getLances().get(0).getValor(), 0.00001);
		assertEquals(1200, leilao.getLances().get(1).getValor(), 0.00001);
	}
	
	
	@Test
	public void naoDevePermitirDoisLancesSequenciaDeUmUsuario() {
		Leilao leilao = new CriadorDeLeilao().
				para("Leilao TV 50")
				.lance(usuario, 1000)
				.lance(usuario, 1200)
				.constroi();

		assertEquals(1, leilao.getLances().size());
		assertEquals(1000, leilao.getLances().get(0).getValor(), 0.00001);
	}
	
	@Test
	public void naoDevePermitirMaisCinoLancesDeUmUsuario() {
		Leilao leilao = new CriadorDeLeilao().
				para("Leilao TV 50")
				.lance(usuario, 1000)
				.lance(usuario2, 2000)
				.lance(usuario, 3000)
				.lance(usuario2, 4000)
				.lance(usuario, 5000)
				.lance(usuario2, 6000)
				.lance(usuario, 7000)
				.lance(usuario2, 8000)
				.lance(usuario, 9000)
				.lance(usuario2, 10000)
				.lance(usuario, 11000)
				.lance(usuario2, 12000)
				.constroi();
		
		
		assertEquals(10, leilao.getLances().size());
		int ultimo = leilao.getLances().size() -1;
		assertEquals(1000, leilao.getLances().get(0).getValor(), 0.00001);
		assertEquals(10000, leilao.getLances().get(ultimo).getValor(), 0.00001);
	}
	
	@Test
	public void deveDobrarLanceDoUsuario() {
		Leilao leilao = new CriadorDeLeilao().
				para("Leilao TV 50")
				.lance(usuario, 1000)
				.lance(usuario2, 1500)
				.constroi();
		
		assertEquals(2, leilao.getLances().size());
		assertEquals(1500, leilao.getLances().get(leilao.getLances().size()-1).getValor(), 0.00001);
		
		leilao.dobraLance(usuario);

		assertEquals(3, leilao.getLances().size());
		assertEquals(2000, leilao.getLances().get(leilao.getLances().size()-1).getValor(), 0.00001);
		
	}
	
	@Test
	public void naoDeveDobrarLanceDoUsuarioSemLance() {
		Leilao leilao = new CriadorDeLeilao().
				para("Leilao TV 50")
				.lance(usuario2, 1500)
				.constroi();
		
		leilao.dobraLance(usuario);

		assertEquals(1, leilao.getLances().size());
		assertEquals(1500, leilao.getLances().get(leilao.getLances().size()-1).getValor(), 0.00001);
		
	}	
	
	@Test
	public void naoDeveDobrarLanceDoMesmoUsuarioUltimoLance() {
		Leilao leilao = new CriadorDeLeilao().
				para("Leilao TV 50")
				.lance(usuario, 1000)
				.lance(usuario2, 1500)
				.constroi();
		
		leilao.dobraLance(usuario2);

		assertEquals(2, leilao.getLances().size());
		assertEquals(1500, leilao.getLances().get(leilao.getLances().size()-1).getValor(), 0.00001);
		
	}	
	
	@Test
	public void naoDeveDobrarLanceUsuarioCincoLance() {
		Leilao leilao = new CriadorDeLeilao().
				para("Leilao TV 50")
				.lance(usuario, 1000)
				.lance(usuario2, 2000)
				.lance(usuario, 3000)
				.lance(usuario2, 4000)
				.lance(usuario, 5000)
				.lance(usuario2, 6000)
				.lance(usuario, 7000)
				.lance(usuario2, 8000)
				.lance(usuario, 9000)
				.lance(usuario2, 10000)
				.constroi();
		
		
		leilao.dobraLance(usuario2);

		assertEquals(10, leilao.getLances().size());
		assertEquals(10000, leilao.getLances().get(leilao.getLances().size()-1).getValor(), 0.00001);
		
	}	

}
