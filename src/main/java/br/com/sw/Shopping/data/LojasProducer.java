package br.com.sw.Shopping.data;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
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

@RequestScoped
@Stateful
public class LojasProducer {
   
   @Inject
   private EntityManager em;

   private List<Loja> lojasPorCategoria = new ArrayList<Loja>();
   
   public void listaLojaPorCategoria(@Observes final Atividades atividades) {       
       CriteriaBuilder cb = em.getCriteriaBuilder();
	   CriteriaQuery<Loja> query = cb.createQuery(Loja.class);
	   Root<Loja> lojas = query.from(Loja.class);
	   query.orderBy(cb.asc(lojas.get(Loja_.nome)));
	   	
	   //if (!atividades.isEmpty()) {
   	   	  ListJoin<Loja,Atividades> join = lojas.join(Loja_.atividades);
   	   	  
   	   	  //for (Atividades atividadeFilter : atividades) {
   	   		  Predicate temAtividades = cb.equal(join.get(Atividades_.id), atividades.getId());
   	   		  query.where(temAtividades);
   	   	  //}
   	   	  
	   //}
       
       lojasPorCategoria = em.createQuery(query).getResultList();
   }
}
