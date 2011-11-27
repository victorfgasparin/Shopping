package br.com.sw.Shopping.model;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Loja.class)
public abstract class Loja_ {

	public static volatile SingularAttribute<Loja, Long> id;
	public static volatile ListAttribute<Loja, Produtos> produtos;
	public static volatile ListAttribute<Loja, Atividades> atividades;
	public static volatile SingularAttribute<Loja, String> nome;
	public static volatile SingularAttribute<Loja, Shopping> shopping;
	public static volatile SingularAttribute<Loja, String> descricao;
	public static volatile SingularAttribute<Loja, String> localizacao;

}

