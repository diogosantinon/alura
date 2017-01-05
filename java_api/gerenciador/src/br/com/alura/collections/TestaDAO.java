package br.com.alura.collections;

import java.util.List;

import br.com.alura.empresa.modelo.Gasto;

public class TestaDAO {
	public static void main(String[] args) {
		GastoDAO dao = new GastoDAO();
		List<Gasto> buscaTodos = dao.buscaTodos();
		for (Gasto gasto : buscaTodos) {
			System.out.println(gasto);
			
		}
		

	}
}
