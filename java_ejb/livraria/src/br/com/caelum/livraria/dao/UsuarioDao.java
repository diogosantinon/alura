package br.com.caelum.livraria.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.caelum.livraria.modelo.Usuario;

@Stateless
public class UsuarioDao {

	@PersistenceContext
	EntityManager manager;

	public Usuario buscaPeloLogin(String login) {
		Usuario usuario = (Usuario) this.manager.createQuery("select u from Usuario u where u.login=:plogin")
										.setParameter("plogin", login).getSingleResult();
		
		return usuario;
	}
	
}
