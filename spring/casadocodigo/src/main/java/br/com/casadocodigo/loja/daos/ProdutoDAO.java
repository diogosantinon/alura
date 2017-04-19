package br.com.casadocodigo.loja.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.casadocodigo.loja.models.Produto;

@Repository
public class ProdutoDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	@Transactional
	public void gravar(Produto produto) {
		manager.persist(produto);
		
	}
	
	public List<Produto> listar(){
	    List<Produto> resultList = manager.createQuery("select p from Produto p").getResultList();
		return resultList;
	}

	public Produto find(Integer id) {
		return manager.createQuery("select distinct(p) from Produto p "
				+ "join fetch p.precos preco where p.id = :id", Produto.class)
				.setParameter("id", id).getSingleResult();
	}

}
