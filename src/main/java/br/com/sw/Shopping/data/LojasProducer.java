package br.com.sw.Shopping.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
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

@SessionScoped
@Stateful
@Named("lojaManager")
public class LojasProducer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7058954616184273446L;

	@Inject
	private EntityManager em;

	private List<Loja> lojasPorCategoria = new ArrayList<Loja>();
	private List<Loja> lojaSelecionada = new ArrayList<Loja>();

	@PostConstruct
	public void init() {
		listaLojaPorCategoria(new Atividades());
	}

	public void listaLojaPorCategoria(@Observes final Atividades atividades) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Loja> query = cb.createQuery(Loja.class);
		Root<Loja> lojas = query.from(Loja.class);
		query.orderBy(cb.asc(lojas.get(Loja_.nome)));

		if (atividades.getId() != null) {
			ListJoin<Loja, Atividades> join = lojas.join(Loja_.atividades);

			// for (Atividades atividadeFilter : atividades) {
			Predicate temAtividades = cb.equal(join.get(Atividades_.id),
					atividades.getId());
			query.where(temAtividades);
			// }

		}

		lojasPorCategoria = em.createQuery(query).getResultList();
	}
	
	public void atualizaProdutos(Loja loja){
		System.out.println("");
	}

	@Produces
	@Named
	public List<Loja> getListaLojas() {
		return lojasPorCategoria;
	}

	@Produces
	@Named
	public List<Loja> getLojaSelecionada() {
		return lojaSelecionada;
	}

}
