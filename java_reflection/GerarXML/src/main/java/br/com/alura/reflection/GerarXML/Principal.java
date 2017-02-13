package br.com.alura.reflection.GerarXML;

import java.util.Map;

public class Principal {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		Usuario user = new Usuario();
		user.setAtivo(Boolean.TRUE);
		user.setSenha("123456");
		user.setEmail("email@email.com");
		user.setLogin("mail");
		user.setPapel("admin");
		
		String xml =  GeradorXML.getXML(user);
		
		System.out.println(xml);
		
		Map<String, Object> map = GeradorXML.getMap(user);
		map.forEach((k,v) -> System.out.println(k + "=" + v));

	}

}
