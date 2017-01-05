package br.com.alura.collections;

import javax.persistence.EntityManager;

public class JPAUtil {

	EntityManager em;
	
	EntityManager getEntityManager(){
		return em;
	}
	
	
}
