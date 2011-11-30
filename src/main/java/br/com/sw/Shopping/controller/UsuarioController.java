package br.com.sw.Shopping.controller;

import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Produces;
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

import br.com.sw.Shopping.model.Atividades;
import br.com.sw.Shopping.model.Usuarios;
import br.com.sw.Shopping.model.Usuarios_;

// The @Stateful annotation eliminates the need for manual transaction demarcation
@Stateful
// The @Model stereotype is a convenience mechanism to make this a
// request-scoped bean that has an
// EL name
// Read more about the @Model stereotype in this FAQ:
// http://sfwk.org/Documentation/WhatIsThePurposeOfTheModelAnnotation
@Named("usuario")
@SessionScoped
public class UsuarioController {

	@Inject
	private EntityManager em;

	@Inject
	private Event<Atividades> filtroAtividades;

	@Inject
	private Usuarios usuarioLogado;

	private String login;
	private String senha;
	
	private boolean loginInvalido = false;

	@Produces
	@Named
	public boolean isLogado() {
		return this.usuarioLogado != null;
	}

	public Boolean getLoginInvalido(){
		return loginInvalido;
	}
	
	@Produces
	@Named
	public void logar() {
		loginInvalido = true;
		if (loginComSucesso()) {
			loginInvalido = false;
		}

		filtroAtividades.fire(new Atividades());
		
		
		
	}

	private boolean loginComSucesso() {
		CriteriaBuilder criteria = em.getCriteriaBuilder();
		CriteriaQuery<Usuarios> query = criteria.createQuery(Usuarios.class);
		Root<Usuarios> u = query.from(Usuarios.class);
		Predicate login = criteria.equal(u.get(Usuarios_.nome), this.login);
		query.where(login);

		TypedQuery<Usuarios> queryDone = em.createQuery(query);
		
		Usuarios usuario = null;
		try{
			usuario = queryDone.getSingleResult();
		} catch (NoResultException e) {
			usuario = null;
		} catch (NonUniqueResultException e) {
			usuario = null;
		}
		
		if (usuario != null && usuario.getSenha().equals(senha)) {
			this.usuarioLogado = usuario;
			return true;
		}
		
		return false;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}