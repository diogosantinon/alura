package br.com.alura.api;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class leEscreveTeclado {

	public static void main(String[] args) throws IOException {
		InputStream is = System.in;
        Scanner entrada = new Scanner(is);
        PrintStream saida = new PrintStream(new FileOutputStream("copia.txt"));
    	try {
            while (entrada.hasNextLine()) {
                saida.println(entrada.nextLine());
            }
    	} catch (Exception e) {
    		System.out.println(e.getMessage());
    	} finally {
			entrada.close();
			saida.close();
		}
	}

}
