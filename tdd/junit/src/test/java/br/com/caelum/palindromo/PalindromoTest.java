package br.com.caelum.palindromo;

import org.junit.Assert;
import org.junit.Test;

import br.com.caelum.palindromo.Palindromo;

public class PalindromoTest {
	
	@Test
	public void deveSerPalindromo() {
		String frase = "Anotaram a data da maratona";
		Palindromo palindromo = new Palindromo();
		boolean teste = palindromo.ehPalindromo(frase);
		
		Assert.assertTrue(teste);
		
	}
	
	@Test
	public void naoDeveSerPalindromo() {
		String frase = "Anotaram a data";
		Palindromo palindromo = new Palindromo();
		boolean teste = palindromo.ehPalindromo(frase);
		
		Assert.assertFalse(teste);
		
	}
	
    @Test
    public void deveIdentificarPalindromoEFiltrarCaracteresInvalidos() {
        Palindromo p = new Palindromo();

        boolean resultado = p.ehPalindromo(
            "Socorram-me subi no onibus em Marrocos");
        Assert.assertTrue(resultado);
    }	
}
