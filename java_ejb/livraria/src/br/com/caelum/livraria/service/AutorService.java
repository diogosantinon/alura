package br.com.caelum.livraria.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;

import br.com.caelum.livraria.dao.AutorDao;
import br.com.caelum.livraria.exception.LivrariaException;
import br.com.caelum.livraria.modelo.Autor;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)  // Opcional
public class AutorService {

	@Inject
	AutorDao dao;
	
	public void adiciona(Autor autor) throws LivrariaException {
		dao.salva(autor);
	}

	public List<Autor> todosAutores() {
		return dao.todosAutores();
	}
}
