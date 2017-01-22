package br.com.caelum.livraria.teste;

import java.rmi.RemoteException;

import br.com.caelum.livraria.webservice.LivrariaWS;
import br.com.caelum.livraria.webservice.LivrariaWSProxy;
import br.com.caelum.livraria.webservice.Livro;

public class TesteRequestSoapComJava {
	
	public static void main(String[] args) throws RemoteException {
		LivrariaWS cliente = new LivrariaWSProxy();
		Livro[] livros = cliente.getLivrosPeloNome("Arquitetura");
		for (Livro livro : livros) {
			System.out.println(livro.getTitulo());
			System.out.println(livro.getAutor());
			
		}
	}

}
