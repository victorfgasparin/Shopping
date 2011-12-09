package br.com.sw.Shopping.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.component.menuitem.MenuItem;
import org.primefaces.model.DefaultMenuModel;
import org.primefaces.model.MenuModel;

import br.com.sw.Shopping.model.Compras;
import br.com.sw.Shopping.model.Produtos;

@SessionScoped
@Named
@Stateful
public class CarrinhoDeCompras {

	private Integer cartao;
	private Integer numCartao;
	private Integer codCartao;
	
	
	public class ItensDeCompra {
		private Produtos produto;
		private Double valor;
		private int quantidade;
		
		public ItensDeCompra(Produtos produto, int quantidade) {
			super();
			this.produto = produto;
			this.valor = produto.getPrecoComPromocao();
			this.quantidade = quantidade;
		}

		public Produtos getProduto() {
			return produto;
		}

		public Double getValor() {
			return valor;
		}

		public int getQuantidade() {
			return quantidade;
		}
		@Override
		public boolean equals(Object obj) {
			ItensDeCompra item = (ItensDeCompra) obj;
			return item.getProduto().ehOmesmo(produto);
		}

		public void setQuantidade(int quantidade) {
			this.quantidade = quantidade;
		}
		
		
	}
	
	@Inject
	private UsuarioController usuario;
	
	private List<ItensDeCompra> itensCarrinho = new ArrayList<ItensDeCompra>();
	private MenuModel carrinhoMenu;

	public List<ItensDeCompra> getItensCarrinho() {
		return itensCarrinho;
	}
	
	

	@Produces
	@Named
	public MenuModel getCarrinho() {
		return carrinhoMenu;
	}
	
	private void atualizaMenuCarrinho(){
		carrinhoMenu = new DefaultMenuModel();
		
		for (ItensDeCompra itemCompra : this.itensCarrinho) {
			MenuItem item = new MenuItem();
			item.setValue(itemCompra.getProduto().getNome().subSequence(0, 7) + "...");
			item.setIcon("/resources/images/produtos/" + itemCompra.getProduto().getImagem());
			
			carrinhoMenu.addMenuItem(item);
		}
	}
	
	public void adicionaCarrinho(@Observes final Produtos produto) {
		int quantidadeAntiga = 0;
		if (itensCarrinho.contains(produto)) {
			ItensDeCompra itemCompra = itensCarrinho.get(itensCarrinho.indexOf(produto));
			quantidadeAntiga = itemCompra.getQuantidade();
			itensCarrinho.remove(itemCompra);
		}
		ItensDeCompra itensDeCompra = new ItensDeCompra(produto, 1 + quantidadeAntiga);
		itensCarrinho.add(itensDeCompra);
		atualizaMenuCarrinho();
	}
	
	@Produces
	@Named
	public Double getTotalPedido(){
		Double total =  0d;
		for (ItensDeCompra itens : itensCarrinho) {
			total += itens.getValor() * itens.getQuantidade();
		}
		return total;
	}
	
	@Produces
	@Named
	public Boolean getCarrinhoVazio(){
		return itensCarrinho.size() == 0;
	}
	
	public void limparCarrinho(){
		itensCarrinho.clear();
		carrinhoMenu = new DefaultMenuModel();
	}
	
	public void efetivarPedido(){
		if (!usuario.isLogado()) {
			
		}else{
			new Compras();
		}
	}



	public Integer getCartao() {
		return cartao;
	}



	public void setCartao(Integer cartao) {
		this.cartao = cartao;
	}



	public Integer getNumCartao() {
		return numCartao;
	}



	public void setNumCartao(Integer numCartao) {
		this.numCartao = numCartao;
	}



	public Integer getCodCartao() {
		return codCartao;
	}



	public void setCodCartao(Integer codCartao) {
		this.codCartao = codCartao;
	}
	
	
}
