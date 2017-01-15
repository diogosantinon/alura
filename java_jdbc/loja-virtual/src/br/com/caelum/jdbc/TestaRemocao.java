package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaRemocao {
	
	public static void main(String[] args) throws SQLException {
		Connection connection = Database.getConnection();
		Statement statement = connection.createStatement();
		
		String sql = "delete from Produto where id > 3"  ;
		int resultado = statement.executeUpdate(sql);
		System.out.println(resultado + " linhas atualizadas");
		connection.close();
		statement.close();
	}

}
