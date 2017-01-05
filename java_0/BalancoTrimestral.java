class BalancoTrimestral {

	public static void main(String[] args) {
		int gastosJaneiro  = 15000;
		int gastosFevereiro = 23000;
		int gastosMarco = 17000;

		int gastosTrimestre = gastosJaneiro + gastosFevereiro + gastosMarco;

		float mediaMensal = gastosTrimestre / 3;

		System.out.println("Gastro Trimestre = " + gastosTrimestre + " média mensal = " + mediaMensal);

/*		int valor = 150;
		while (valor < 300) {
			System.out.println(valor);
			valor ++;
		}*/
/*
		int soma = 0;
		for (int i = 1; i <= 1000; i++) {
			soma += i;
		}
		System.out.println("Soma de 1 a 1000 é = " + soma);*/

/*		
		for (int i = 3; i <= 100; i += 3) {
			System.out.println("Multiplo de 3 = " + i);		
		}*/
		
/*
        long fatorial = 1;
        for (int i = 1; i < 30; i++) {
            fatorial *= i;
            System.out.println("Fatorial de "+i+ " = " +fatorial);
        }*/

        int x = 13;
        System.out.print(x);
        while (x != 1) {
        	if (x % 2 == 0) {
    			x /= 2;
        	} else {
    			x = 3 * x + 1;
        	}
    		
    		System.out.print(" > " + x);
        }	


	}

}