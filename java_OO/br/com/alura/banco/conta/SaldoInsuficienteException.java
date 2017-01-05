package br.com.alura.banco.conta;

public class SaldoInsuficienteException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6116238569354930430L;
	
    SaldoInsuficienteException(String message) {
        super(message);
    }	
	
}
