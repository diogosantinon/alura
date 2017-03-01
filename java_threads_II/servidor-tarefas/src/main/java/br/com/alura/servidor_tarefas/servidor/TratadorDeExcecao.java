package br.com.alura.servidor_tarefas.servidor;

import java.lang.Thread.UncaughtExceptionHandler;

public class TratadorDeExcecao implements UncaughtExceptionHandler {

	public void uncaughtException(Thread t, Throwable e) {
		System.out.println("Deu excecao na " + t.getName() + " " + e.getMessage());

	}

}
