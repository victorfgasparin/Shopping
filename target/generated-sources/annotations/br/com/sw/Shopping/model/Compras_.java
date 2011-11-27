package br.com.sw.Shopping.model;

import java.util.Calendar;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Compras.class)
public abstract class Compras_ {

	public static volatile SingularAttribute<Compras, Long> id;
	public static volatile ListAttribute<Compras, ProdutosCompra> produtosCompras;
	public static volatile SingularAttribute<Compras, Usuarios> usuario;
	public static volatile SingularAttribute<Compras, String> codigoSeguranca;
	public static volatile SingularAttribute<Compras, String> numeroCartao;
	public static volatile SingularAttribute<Compras, Integer> bandeiraCartao;
	public static volatile SingularAttribute<Compras, Calendar> dataCompra;
	public static volatile SingularAttribute<Compras, Integer> formaPagamento;

}

