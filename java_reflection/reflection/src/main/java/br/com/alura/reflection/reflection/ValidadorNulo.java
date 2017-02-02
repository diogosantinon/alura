package br.com.alura.reflection.reflection;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ValidadorNulo {

//	public static List<String> getAtrubutosNulos(Produto p) {
//		List<String> lista = new ArrayList<String>();
//		if(p.codigo == null) {
//			lista.add("codigo");
//		}
//		if(p.descricao== null) {
//			lista.add("descricao");
//		}
//		if(p.fornecedor== null) {
//			lista.add("fornecedor");
//		}		
//		if(p.nome == null) {
//			lista.add("nome");
//		}					
//		if(p.preco == null) {
//			lista.add("preco");
//		}							
//		return lista;
//	}
//
//	public static List<String> getAtrubutosNulos(Usuario u) {
//		List<String> lista = new ArrayList<String>();
//		if(u.ativo == null) {
//			lista.add("ativo");
//		}
//		if(u.email == null) {
//			lista.add("email");
//		}
//		if(u.login == null) {
//			lista.add("login");
//		}		
//		if(u.papel == null) {
//			lista.add("papel");
//		}					
//		if(u.senha == null) {
//			lista.add("senha");
//		}							
//		return lista;
//	}
//
//	public static List<String> getAtrubutosNulos(NotaFiscal nf) {
//		List<String> lista = new ArrayList<String>();
//		if(nf.cnpj == null) {
//			lista.add("cnpj");
//		}
//		if(nf.data == null) {
//			lista.add("data");
//		}
//		if(nf.endereco == null) {
//			lista.add("endereco");
//		}		
//		if(nf.sequencia == null) {
//			lista.add("sequencia");
//		}					
//		if(nf.talao == null) {
//			lista.add("talao");
//		}							
//		return lista;
//	}
//	
	public static List<String> getAtrubutosNulos(Object o) {
		List<String> lista = new ArrayList<String>();
		try {
			Class<?> c = o.getClass();
			for(Field f : c.getFields()) {
				Object value = f.get(o);
				if(value == null) {
					lista.add(f.getName());
				}
		}
		
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
		
	}

}
