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

import br.com.sw.Shopping.model.Atividades;
import br.com.sw.Shopping.model.Atividades_;
import br.com.sw.Shopping.model.Loja;
import br.com.sw.Shopping.model.Loja_;

@Stateful
@Named
public class LojasDao {

	@Inject
	EntityManager em;
	
	public List<Loja> getlistaLojas(Atividades atividade){
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Loja> query = cb.createQuery(Loja.class);
		Root<Loja> lojas = query.from(Loja.class);
		query.orderBy(cb.asc(lojas.get(Loja_.nome)));

		if (atividade.getId() != null) {
			ListJoin<Loja, Atividades> join = lojas.join(Loja_.atividades);

			// for (Atividades atividadeFilter : atividades) {
			Predicate temAtividades = cb.equal(join.get(Atividades_.id),
					atividade.getId());
			query.where(temAtividades);
			// }
		}
		
		return em.createQuery(query).getResultList();
	}

}
