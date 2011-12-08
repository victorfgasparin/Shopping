package br.com.sw.Shopping.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import br.com.sw.Shopping.dao.LojasDao;
import br.com.sw.Shopping.dao.ProdutoDao;
import br.com.sw.Shopping.model.Loja;
import br.com.sw.Shopping.model.Produtos;

@SessionScoped
@Stateful
@Named("produtosManager")
public class ProdutosProducer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7058954616184273446L;

	@Inject
	private EntityManager em;
	
	@Inject
	private ProdutoDao produtosDao;
	@Inject
	private LojasDao lojasDao;

	private List<Produtos> produtos = new ArrayList<Produtos>();

	@PostConstruct
	public void init() {
	}

	@Produces
	@Named
	public List<Produtos> getProdutos() {
		return produtos;
	}
	
	public void atualizaProdutos(@Observes final Loja loja){
		Loja lojaSelecionada = lojasDao.getById(loja.getId());
		produtos = lojaSelecionada.getProdutos();
		
		for (Produtos prod : produtos) {
			prod.getId();
		}
	}
	
	
}
