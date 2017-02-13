package br.com.alura.reflection.validador;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Validador {
	
	public static boolean validarObjeto(Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		boolean resultado = true;
		
		Class<?> clazz = obj.getClass();
		
		for(Method m : clazz.getMethods()) {
			if(m.getName().startsWith("validar") 
					&& m.getReturnType() == boolean.class 
					&& m.getParameterTypes().length == 0) {
				Boolean retorno = (Boolean) m.invoke(obj);
				resultado = resultado && retorno.booleanValue();
			}
		}
		
		return resultado;
	}
	
	public static void invocadorTestes(Object obj) throws Exception, IllegalArgumentException, InvocationTargetException {
		Class<?> clazz = obj.getClass();
		
		for (Method m : clazz.getDeclaredMethods()) {
			if(m.getName().startsWith("test")
					&& m.getReturnType().equals(void.class)
					&& m.getParameterCount() == 0 
					) {
				System.out.println(m.getName());
				
				m.invoke(obj);
			}
		}
		
		
	}

}
