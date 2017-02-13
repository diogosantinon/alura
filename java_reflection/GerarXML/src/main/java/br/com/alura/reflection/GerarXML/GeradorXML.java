package br.com.alura.reflection.GerarXML;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class GeradorXML {
	public static String getXML(Object obj) throws IllegalArgumentException, IllegalAccessException {
		StringBuilder sb = new StringBuilder();
		
		Class<?> clazz = obj.getClass();
		
		sb.append("<"+ clazz.getSimpleName() +"> \n");
		
		for (Field field : clazz.getDeclaredFields()) {
			sb.append("<"+ field.getName() +">");
			//
			field.setAccessible(true);
			sb.append(field.get(obj));
			sb.append("</"+ field.getName() +"> \n");
		}
		
		sb.append("</"+ clazz.getSimpleName() +">");
		return sb.toString();
	}
	
	public static Map<String, Object> getMap(Object obj) throws IllegalArgumentException, IllegalAccessException {
		Map<String, Object> mapaRetorno = new HashMap();
		
		Class<?> clazz = obj.getClass();
		
		for (Field field : clazz.getDeclaredFields()) {
			field.setAccessible(true);
			String key = field.getName();
			Object valor =  field.get(obj); 
			mapaRetorno.put(key, valor);
		}
		
		
		return mapaRetorno;
	}

}
