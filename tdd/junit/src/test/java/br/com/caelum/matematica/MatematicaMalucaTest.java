package br.com.caelum.matematica;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.caelum.matematica.MatematicaMaluca;

public class MatematicaMalucaTest {
	
	@Test
	public void deveMultiplicarNumerosMaioresQue30() {
		MatematicaMaluca maluca = new MatematicaMaluca();
		int resultado = maluca.contaMaluca(31);
		assertEquals(124, resultado);
	}
	
	@Test
	public void deveMultiplicarNumerosMaioresQue10EMenoresQue30() {
		MatematicaMaluca maluca = new MatematicaMaluca();
		int resultado = maluca.contaMaluca(15);
		assertEquals(45, resultado);
	}
	
	@Test
	public void deveMultiplicarNumerosMenoresQue10() {
		MatematicaMaluca maluca = new MatematicaMaluca();
		int resultado = maluca.contaMaluca(5);
		assertEquals(10, resultado);
	}	

}
