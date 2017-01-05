package br.com.alura.empresa.modelo;

import java.util.Calendar;

import br.com.alura.collections.Funcionario;

public class TesteGastos {

	public static void main(String[] args) {
        Calendar hoje = Calendar.getInstance();
        Funcionario funcionario = new Funcionario("Vinícius", 9);

        Gasto gasto = new Gasto(40.0, "taxi", funcionario, hoje);
        Gasto gasto1 = new Gasto(40.0, "taxi", funcionario, hoje);
        Gasto gasto2 = new Gasto(40.0, "taxi", funcionario, hoje);

        System.out.println(gasto);
        System.out.println(gasto1);
        System.out.println(gasto2);
	}

}
