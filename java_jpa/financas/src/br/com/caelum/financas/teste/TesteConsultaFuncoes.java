package br.com.caelum.financas.teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.caelum.financas.dao.MovimentacaoDao;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteConsultaFuncoes {

	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManager();
		Conta conta = new Conta();
		conta.setId(3);
		
		soma(manager, conta);
        
        media(manager, conta);
        
        dao(manager, conta);
        
        namedQuery(manager, conta);
        
        manager.close();
	}

	private static void soma(EntityManager manager, Conta conta) {
		String jpql = "select sum(m.valor) from Movimentacao m where m.conta=:pConta "
		        + "and m.tipoMovimentacao=:pTipo";
		
		TypedQuery<BigDecimal> query = manager.createQuery(jpql, BigDecimal.class);

        query.setParameter("pConta", conta);
        query.setParameter("pTipo", TipoMovimentacao.SAIDA);

        BigDecimal resultado = query.getSingleResult();

        System.out.println("Total movimentado ..: R$ " + resultado);
	}

	private static void media(EntityManager manager, Conta conta) {
		String jpql;
		jpql = "select avg(m.valor) from Movimentacao m where m.conta=:pConta "
                + "and m.tipoMovimentacao=:pTipo";

        TypedQuery<Double> query1 = manager.createQuery(jpql, Double.class);

        query1.setParameter("pConta", conta);
        query1.setParameter("pTipo", TipoMovimentacao.SAIDA);

        Double resultado1 = query1.getSingleResult();

        System.out.println("Total movimentado ..: R$ " + resultado1);
	}

	private static void dao(EntityManager manager, Conta conta) {
		MovimentacaoDao dao = new MovimentacaoDao(manager);
        
        Double resutado2 = dao.mediaDaContaPeloTipo(conta, TipoMovimentacao.SAIDA);
        System.out.println("Resultado 2 ...: R$" + resutado2);
	}
	
	private static void namedQuery(EntityManager manager, Conta conta) {
		TypedQuery<Double> query = manager.
                createNamedQuery("mediaDaContaPeloTipoMovimentacao", Double.class);

        query.setParameter("pConta", conta);
        query.setParameter("pTipo", TipoMovimentacao.ENTRADA);

        Double media =  query.getSingleResult();

        System.out.println(media);
	}
	
	
}
