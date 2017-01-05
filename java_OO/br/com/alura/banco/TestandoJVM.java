package br.com.alura.banco;

import java.io.FileNotFoundException;

public class TestandoJVM {
	public static void main(String[] args) {
/*        int i = 5571;
        i = i / 0;
        System.out.println("O resultado  " + i);
		Conta c = null;
        System.out.println("Saldo atual " + c.getSaldo());		*/
		try {
			new java.io.FileInputStream("arquivo.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
