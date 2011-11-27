package br.com.sw.Shopping.model;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(ProdutosCompra.class)
public abstract class ProdutosCompra_ {

	public static volatile SingularAttribute<ProdutosCompra, Long> id;
	public static volatile SingularAttribute<ProdutosCompra, Compras> compra;
	public static volatile SingularAttribute<ProdutosCompra, Produtos> produto;
	public static volatile SingularAttribute<ProdutosCompra, Double> valor;

}

