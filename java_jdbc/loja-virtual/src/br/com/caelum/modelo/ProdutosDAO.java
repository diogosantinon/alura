package br.com.caelum.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProdutosDAO {
    private Connection con;

    public ProdutosDAO(Connection con) {
        this.con = con;
    }
    
    public List<Produto> lista() throws SQLException {
        List<Produto> produtos = new ArrayList<>();
        String sql = "select * from Produto";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.execute();
            transformadorResultadoEmProdutos(produtos, stmt);
        }
        
        return produtos;
    }

	private void transformadorResultadoEmProdutos(List<Produto> produtos, PreparedStatement stmt) throws SQLException {
		try (ResultSet rs = stmt.getResultSet()) {
		    while (rs.next()) {
		        int id = rs.getInt("id");
		        String nome = rs.getString("nome");
		        String descricao = rs.getString("descricao");
		        Produto produto = new Produto(nome, descricao);
		        produto.setId(id);
		        produtos.add(produto);
		    }
		}
	}    

	public void salvaProduto(Produto produto) throws SQLException {
		
	    String sql = "insert into Produto (nome, descricao) values(?, ?)";

	    try(PreparedStatement statement = con.prepareStatement(sql,
	                Statement.RETURN_GENERATED_KEYS)) {
	        statement.setString(1, produto.getNome() );
	        statement.setString(2,  produto.getDescricao() );

	        statement.execute();
	        
            try (ResultSet rs = statement.getGeneratedKeys()) {
                if (rs.next()) {
                    int id = rs.getInt("id");
                    produto.setId(id);
                    System.out.println("Produto inserido com sucesso " + produto);
                }
            }
	        
	    }
	}
	
	public List<Produto> buscaPorCategoria(Categoria categoria) throws SQLException {
        List<Produto> produtos = new ArrayList<>();
        String sql = "select * from Produto where categoria_id = ?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, categoria.getId());
            stmt.execute();

            transformadorResultadoEmProdutos(produtos, stmt);

        }        
        return produtos;		
	}
    
}
