package br.com.caelum.livraria.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.caelum.livraria.modelo.Autor;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
//@Interceptors({LogInterceptor.class})
public class AutorDao {

	@PersistenceContext
	EntityManager manager;
	
	public void salva(Autor autor) {
		System.out.println("Inicio");
		manager.persist(autor);
		System.out.println("Fim");
//		throw new RuntimeException("Serviço externo deu erro!");
	}
	
	public List<Autor> todosAutores() {
		return manager.createQuery("select a from Autor a", Autor.class).getResultList();
	}

	public Autor buscaPelaId(Integer autorId) {
		return manager.find(Autor.class, autorId);
	}
	
	@PostConstruct
	void aposCriacao() {
		System.out.println("AutorDao foi criado");
	}
	
}
