package br.com.alura.api;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class leTeclado {
    public static void main(String[] args) throws IOException {
    	InputStream is = System.in;
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
