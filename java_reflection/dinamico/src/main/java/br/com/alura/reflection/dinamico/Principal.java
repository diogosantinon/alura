package br.com.alura.reflection.dinamico;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Principal {

	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {
		Mapeador map = new Mapeador();
		map.load("classes.prop");
		System.out.println(map.getImplementacao(List.class));
		System.out.println(map.getImplementacao(Map.class));
	}

}
