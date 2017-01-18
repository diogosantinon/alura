package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.caelum.modelo.Produto;
import br.com.caelum.modelo.ProdutosDAO;

public class TesteProduto {
	
	public static void main(String[] args) throws SQLException {
		Produto mesa = new Produto("Mesa Azul", "Nesa com 4 pés");
		try (Connection connection = new ConnectionPool().getConnection()) {
			ProdutosDAO dao = new ProdutosDAO(connection);
			dao.salvaProduto(mesa);
			
            List<Produto> produtos = dao.lista();
            for (Produto produto : produtos) {
                System.out.println("Existe o produto: " + produto);
            }			
			
		}
		
	}



}
