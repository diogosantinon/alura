package br.com.alura.reflection.reflection;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ValidadorAtributosString {
	
	public static List<String> getAtributosString(Object o) {
		List<String> lista = new ArrayList<String>();
		
		try {
			Class<?> classe = o.getClass();
			for (Field field : classe.getFields()) {
				if(String.class.equals(field.getType())) {
					lista.add(field.getName());
				}
			}
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
	
	public static List<String> buscaStringEmAtributos(Object o, String buscada){
	    try {
	        List<String> lista = new ArrayList<String>();
	        Class<?> c = o.getClass();
	        for(Field f : c.getFields()){
	            Object value = f.get(o);
	            if(value != null){
	                String strValue = value.toString();
	                if(strValue.contains(buscada)){
	                    lista.add(f.getName());
	                }
	            }
	        }
	        return lista;
	    } catch (Exception e) {
	        e.printStackTrace();
	        throw new RuntimeException(e);
	    }
	}
}
