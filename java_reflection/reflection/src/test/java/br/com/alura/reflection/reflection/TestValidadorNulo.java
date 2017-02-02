package br.com.alura.reflection.reflection;

import java.util.Date;
import java.util.List;

import org.junit.Test;


public class TestValidadorNulo {
	
	@Test
	public void testProduto() {
		Produto p = new Produto();
		p.codigo = "123456";
		p.preco = 355.35f;
		p.fornecedor = "Fabrica";
		
		List<String> lista = ValidadorNulo.getAtrubutosNulos(p);
		org.junit.Assert.assertEquals(2, lista.size());
		org.junit.Assert.assertTrue(lista.contains("descricao"));
		org.junit.Assert.assertTrue(lista.contains("nome"));
	}

	@Test
	public void testUsuario() {
		Usuario u = new Usuario();
		u.ativo = true;
		u.email = "usuario@email.com";
		u.papel = "admin";
		u.login = "master";
		
		List<String> lista =  ValidadorNulo.getAtrubutosNulos(u);
		org.junit.Assert.assertEquals(1, lista.size());
		org.junit.Assert.assertTrue(lista.contains("senha"));
	}
	

	@Test
	public void testNofaFiscal() {
		NotaFiscal nf = new NotaFiscal();
		nf.talao = 1;
		nf.sequencia = 123456789;
		nf.data = new Date();
		
		List<String> lista =  ValidadorNulo.getAtrubutosNulos(nf);
		org.junit.Assert.assertEquals(2, lista.size());
		org.junit.Assert.assertTrue(lista.contains("cnpj"));
		org.junit.Assert.assertTrue(lista.contains("endereco"));
	}

}
