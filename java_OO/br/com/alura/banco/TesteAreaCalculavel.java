package br.com.alura.banco;

import br.com.alura.avulsos.AreaCalculavel;
import br.com.alura.avulsos.Retangulo;

public class TesteAreaCalculavel {
	public static void main(String[] args) {
        AreaCalculavel a = new Retangulo(3,2);
        System.out.println(a.calculaArea());
	}
}
