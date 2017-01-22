package br.com.caelum.livraria.interceptador;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;


public class LogInterceptor {
	
	@AroundInvoke
	public Object intercepta(InvocationContext context) throws Exception {
		long millis = System.currentTimeMillis();
		
		Object object = context.proceed();
		
		String metodo = context.getMethod().getName();
		String nomeClasse = context.getTarget().getClass().getSimpleName();
		System.out.println(nomeClasse + ", " + metodo);
	    System.out.println("Tempo gasto:  " + (System.currentTimeMillis() - millis));
	    return object;
	}

}
