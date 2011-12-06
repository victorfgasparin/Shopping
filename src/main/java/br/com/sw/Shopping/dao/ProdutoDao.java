package br.com.sw.Shopping.dao;

import java.util.List;

import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ListJoin;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.sw.Shopping.model.Categorias;
import br.com.sw.Shopping.model.Categorias_;
import br.com.sw.Shopping.model.Loja;
import br.com.sw.Shopping.model.Produtos;
import br.com.sw.Shopping.model.Produtos_;

@Stateful
@Named
public class ProdutoDao {

	@Inject
	EntityManager em;
	
	public List<Produtos> getlistaProdutos(Loja loja){
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Produtos> query = cb.createQuery(Produtos.class);
		Root<Produtos> produtos = query.from(Produtos.class);
		query.orderBy(cb.asc(produtos.get(Produtos_.precoVenda)));

		if (loja != null) {
			Predicate daLoja = cb.equal(produtos.get(Produtos_.loja), loja);
			query.where(daLoja);
		}
		
		return em.createQuery(query).getResultList();
	}
	
	public List<Produtos> getlistaProdutos(Loja loja, Categorias categoria){
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Produtos> query = cb.createQuery(Produtos.class);
		Root<Produtos> produtos = query.from(Produtos.class);
		query.orderBy(cb.asc(produtos.get(Produtos_.precoVenda)));

		if (loja != null) {
			Predicate daLoja = cb.equal(produtos.get(Produtos_.loja), loja);
			query.where(daLoja);
		}
		
		if (categoria != null) {
			ListJoin<Produtos, Categorias> join = produtos.join(Produtos_.categorias);
			Predicate temCategoria = cb.equal(join.get(Categorias_.id),categoria.getId());
			query.where(temCategoria);
		}
		
		return em.createQuery(query).getResultList();
	}

}
