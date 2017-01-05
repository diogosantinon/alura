package br.com.alura.avulsos;

import br.com.alura.banco.conta.Autenticavel;

public class SistemaInterno {
	  void login(Autenticavel a) {
		     int senha = 1;
		     boolean autenticado = a.autentica(senha);
		     // aqui eu posso chamar o autentica! 
		     // não necessariamente é um Funcionario!
		     // Mais ainda, eu não sei que objeto a 
		     // referência "a" está apontando exatamente! Flexibilidade.
		  }	

}
