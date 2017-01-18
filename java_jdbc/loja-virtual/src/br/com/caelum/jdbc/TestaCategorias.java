package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.caelum.modelo.Categoria;
import br.com.caelum.modelo.CategoriasDAO;
import br.com.caelum.modelo.Produto;
import br.com.caelum.modelo.ProdutosDAO;

public class TestaCategorias {
	
	public static void main(String[] args) throws SQLException {
        try(Connection con = new ConnectionPool().getConnection()) {
        	CategoriasDAO dao = new CategoriasDAO(con);
        	//N+1 
        	List<Categoria> categorias = dao.lista();
            for(Categoria categoria : categorias) {
                System.out.println(categoria.getNome());
                
                List<Produto> todosOsProdutosDestaCategoria = new ProdutosDAO(con).buscaPorCategoria(categoria);
                
                for(Produto produto : todosOsProdutosDestaCategoria ) {
                	System.out.println(categoria.getNome() + " - " + produto.getNome());
                }
            }
        }		
        //sem N+1
        try(Connection con = new ConnectionPool().getConnection()) {
            List<Categoria> categorias = new CategoriasDAO(con).listaComProdutos();
            for(Categoria categoria : categorias) {
                System.out.println(categoria.getNome());

                for(Produto produto : categoria.getProdutos()) {
                    System.out.println(categoria.getNome() + " - " + produto.getNome());
                }                
            }
        }        
	}

}
