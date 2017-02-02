package br.com.alura.reflection.reflection;

import java.util.List;

import org.junit.Test;

public class TestAtributosString {

	@Test
	public void deveRetornarAtributosStrings() {
		Produto p = new Produto();
		List<String> lista = ValidadorAtributosString.getAtributosString(p);
		org.junit.Assert.assertEquals(4, lista.size());
		org.junit.Assert.assertTrue(lista.contains("descricao"));
		org.junit.Assert.assertTrue(lista.contains("nome"));
		org.junit.Assert.assertTrue(lista.contains("fornecedor"));
		org.junit.Assert.assertTrue(lista.contains("codigo"));
	}
}
