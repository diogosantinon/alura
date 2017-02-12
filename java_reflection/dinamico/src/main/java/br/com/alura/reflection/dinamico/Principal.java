package br.com.alura.reflection.dinamico;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Principal {

	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		Mapeador map = new Mapeador();
		map.load("classes.prop");
		
//		List l = map.getInstancia(List.class);
//		System.out.println(l.getClass());
//		
//		
//		System.out.println(map.getImplementacao(List.class));
//		System.out.println(map.getImplementacao(Map.class));
		
		InterfaceExemplo i = map.getInstancia(InterfaceExemplo.class, "teste");
		System.out.println(i.getClass());
	}

}
