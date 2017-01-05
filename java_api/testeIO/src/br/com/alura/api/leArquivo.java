package br.com.alura.api;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class leArquivo {

	public static void main(String[] args) throws IOException {
		InputStream is = new FileInputStream("arquivo.txt");
        Scanner entrada = new Scanner(is);

    	try {
	        String s = entrada.nextLine();
	
	        while (s != null) {
	            System.out.println(s);
	            s = entrada.nextLine();
	        }
    	} catch (Exception e) {
    		System.out.println(e.getMessage());
    	} finally {
			entrada.close();
		}
	}

}
