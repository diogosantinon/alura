package br.com.caelum.matematica;

import static org.junit.Assert.*;

import org.junit.Test;

public class AnoBissextoTest {
	
	@Test
	public void deveSerAnoBissextoMultiplo400() {
		assertTrue(AnoBissexto.ehBissexto(400));
	}
	
	@Test
	public void naoDeveSerAnoBissextoNaoMultiplo400() {
		assertFalse(AnoBissexto.ehBissexto(500));
	}
	
	@Test
	public void naoDeveSerAnoBissextoCada100() {
		assertFalse(AnoBissexto.ehBissexto(100));
		assertFalse(AnoBissexto.ehBissexto(600));
	}
	
	@Test
	public void deveSerAnoBissextoMultiplo4() {
		assertTrue(AnoBissexto.ehBissexto(4));
	}
	
	public void naoDeveSerAnoBissextoNaoMultiplo4() {
		assertTrue(AnoBissexto.ehBissexto(3));
		assertTrue(AnoBissexto.ehBissexto(791));
	}	

}
