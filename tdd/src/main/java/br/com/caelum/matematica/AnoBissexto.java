package br.com.caelum.matematica;

public class AnoBissexto {
	
	public static boolean ehBissexto(int ano) {
		boolean eh = false;
		if(ehMultiplo400(ano) || (naoEhMultiplo100(ano) && ehMultiplo4(ano)) ) {
			eh = true;
		}
		return eh;
	}

	private static boolean ehMultiplo400(int ano) {
		return ano % 400 == 0;
	}
	
	private static boolean naoEhMultiplo100(int ano) {
		return ano % 100 != 0;
	}	
	
	private static boolean ehMultiplo4(int ano) {
		return ano % 4 == 0;
	}	

}
