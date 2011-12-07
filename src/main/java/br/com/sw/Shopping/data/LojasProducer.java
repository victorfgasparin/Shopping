package br.com.sw.Shopping.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;
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
	
	@Inject
	private Event<Loja> lojaEvent;

	private List<Loja> lojasPorCategoria = new ArrayList<Loja>();
	private List<Loja> lojaSelecionada = new ArrayList<Loja>();

	@PostConstruct
	public void init() {
		listaLojaPorCategoria(new Atividades());
	}

	public void listaLojaPorCategoria(@Observes final Atividades atividades) {
		lojasPorCategoria = lojasDao.getlistaLojas(atividades);
	}
	
	public void atualizaProdutos(){
		String lojaId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("loja");
		Loja lojaSelecionada = lojasDao.getById(Long.parseLong(lojaId));
		lojaEvent.fire(lojaSelecionada);
	}
	
	public void comoChegar(){
		String lojaId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("loja");
		Loja lojaSelecionada = lojasDao.getById(Long.parseLong(lojaId));
		lojaEvent.fire(lojaSelecionada);
	}

	@Produces
	@Named
	public List<Loja> getListaLojas() {
		return lojasPorCategoria;
	}
	
	@Produces
	@Named
	public List<LojasMenu> getListaLojasMenu() {
		List<LojasMenu> lojasMenu = new ArrayList<LojasMenu>();
		List<Loja> listaLojas = this.getListaLojas();
		for (Loja loja : listaLojas) {
			lojasMenu.add(new LojasMenu(loja));
		}
		return lojasMenu;
		
	}
	
	@Produces
	@Named
	public boolean getLojaSelecionada() {
		return lojaSelecionada != null;
	}

}
