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
	private Event<Usuarios> loginEvent;

	private Usuarios usuarioLogado = Usuarios.getUsuarioAnonimo();

	private String login;
	private String senha;
	
	private String novoLogin;
	private String novaSenha;
	
	private boolean loginInvalido = false;

	@Produces
	@Named
	public boolean isLogado() {
		return !this.usuarioLogado.isAnonimo();
	}

	@Produces
	@Named
	public Boolean getLoginInvalido(){
		return loginInvalido;
	}
	
	@Produces
	@Named
	public String logar() {
		loginInvalido = true;
		if (loginComSucesso()) {
			loginInvalido = false;
			loginEvent.fire(usuarioLogado);
		}
		
		if (!loginInvalido) {
			return "loginSucesso";
		}
		return null;	
	}
	
	@Produces
	@Named
	public String cadastraNovoUsuario(){
		return "loginSucesso";
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
	
	public String logout(){
		usuarioLogado = Usuarios.getUsuarioAnonimo();
		loginEvent.fire(usuarioLogado);
		return "home";
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
	
	public String getNome(){
		if (isLogado()) {
			return usuarioLogado.getNome();
		}
		return null;
	}

	public String getNovoLogin() {
		return novoLogin;
	}

	public void setNovoLogin(String novoLogin) {
		this.novoLogin = novoLogin;
	}

	public String getNovaSenha() {
		return novaSenha;
	}

	public void setNovaSenha(String novaSenha) {
		this.novaSenha = novaSenha;
	}
}
