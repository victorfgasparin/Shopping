package br.com.sw.Shopping.controller;

import javax.ejb.Stateful;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.sw.Shopping.model.Produtos;
import br.com.sw.Shopping.model.Usuarios;
import br.com.sw.Shopping.model.Usuarios_;

// The @Stateful annotation eliminates the need for manual transaction demarcation
@Stateful
// The @Model stereotype is a convenience mechanism to make this a
// request-scoped bean that has an
// EL name
// Read more about the @Model stereotype in this FAQ:
// http://sfwk.org/Documentation/WhatIsThePurposeOfTheModelAnnotation
@Named("pedido")
@SessionScoped
public class PedidoController {

	@Inject
	private EntityManager em;
	
	@Inject
	private Event<Produtos> produtoEvent;

	public void adicionaProduto(){
		String productoId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("produto");
		if (productoId != null) {
			Produtos produtoSelecionado = em.find(Produtos.class, Long.parseLong(productoId));
			produtoSelecionado.getId();
			produtoEvent.fire(produtoSelecionado);
		}
	}
}
