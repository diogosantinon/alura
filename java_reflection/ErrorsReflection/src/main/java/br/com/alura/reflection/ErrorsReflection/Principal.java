package br.com.alura.reflection.ErrorsReflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Principal {

	public static void main(String[] args) throws Exception {
		TestErrors obj = new TestErrors();
		
		Class clazz = obj.getClass();
//		clazz.getMethod("metodo");
		try {
	//		Method method = clazz.getMethod("metodo", String.class);
			Method method = clazz.getDeclaredMethod("metodo", String.class);
			
	//		method.invoke(obj, 23);
			method.invoke(obj, "string");
		} catch (InvocationTargetException e) {
			e.getTargetException().printStackTrace();
		}
		
	}

}
