package br.com.alura.collections;

import java.util.ArrayList;
import java.util.Collections;

public class TestandoListas {

    public static void main(String[] args) {

        String aula1 = "Modelando a classe Aula";
        String aula2 = "Conhecendo mais de listas";
        String aula3 = "Trabalhando com Cursos e Sets";

        ArrayList<String> aulas = new ArrayList<>();
        aulas.add(aula1);
        aulas.add(aula2);
        aulas.add(aula3);        

        System.out.println(aulas);
        
        aulas.remove(0);
        System.out.println(aulas);
        
        imprimir(aulas);
        aulas.add(aula1);
        Collections.sort(aulas);
        imprimir(aulas);
        
    }

	private static void imprimir(ArrayList<String> aulas) {
		aulas.forEach(aula -> {
            System.out.println("Aula " + aula);
        });
	}
}