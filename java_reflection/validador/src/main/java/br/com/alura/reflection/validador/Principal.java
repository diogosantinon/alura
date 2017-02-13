package br.com.alura.reflection.validador;

public class Principal {

	public static void main(String[] args) throws Exception {
		Usuario user = new Usuario();
		user.setAtivo(Boolean.TRUE);
		user.setSenha("123456882");
		user.setEmail("email@email.com");
		user.setLogin("papapa");
		user.setPapel("admin");
		
		boolean validarObjeto = Validador.validarObjeto(user);
		
		if(validarObjeto) {
			System.out.println("O objeto é valido");
		} else {
			System.out.println("O ojeto é invalido");
		}
		
		Validador.invocadorTestes(user);
	}

}
