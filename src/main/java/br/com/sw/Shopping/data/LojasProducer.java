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

import br.com.sw.Shopping.dao.LojasDao;
import br.com.sw.Shopping.model.Atividades;
import br.com.sw.Shopping.model.Loja;

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
	
	@Inject
	private LojasDao lojasDao;

	private List<Loja> lojasPorCategoria = new ArrayList<Loja>();
	private List<Loja> lojaSelecionada = new ArrayList<Loja>();

	@PostConstruct
	public void init() {
		listaLojaPorCategoria(new Atividades());
	}

	public void listaLojaPorCategoria(@Observes final Atividades atividades) {
		lojasPorCategoria = lojasDao.getlistaLojas(atividades);
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
	public boolean getLojaSelecionada() {
		return lojaSelecionada != null;
	}

}
