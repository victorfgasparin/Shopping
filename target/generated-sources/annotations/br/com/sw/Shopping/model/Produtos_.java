package br.com.sw.Shopping.model;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Produtos.class)
public abstract class Produtos_ {

	public static volatile SingularAttribute<Produtos, Long> id;
	public static volatile SingularAttribute<Produtos, Integer> quantidade;
	public static volatile SingularAttribute<Produtos, Loja> loja;
	public static volatile ListAttribute<Produtos, Categorias> categorias;
	public static volatile SingularAttribute<Produtos, String> nome;
	public static volatile SingularAttribute<Produtos, String> descricao;

}

