package br.com.alura.collections;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class DAO<T> {

    private final EntityManager entityManager = new JPAUtil()
            .getEntityManager();
    private Class<T> classe;

    public DAO(Class<T> classe) {
        super();
        this.classe = classe;
    }

    public void adiciona(T entity) {
        entityManager.persist(entity);
    }

    public T atualiza(T entity) {
        return entityManager.merge(entity);
    }

    public void remove(T entity) {
        entityManager.remove(entity);
    }

    public T buscaPorId(Long id) {

        return entityManager.find(classe, id);
    }

    public List<T> buscaTodos() {
        Query query = entityManager.createQuery("from " + classe.getName());
        return query.getResultList();
    }
}