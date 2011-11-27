package br.com.sw.Shopping.model;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Shopping.class)
public abstract class Shopping_ {

	public static volatile SingularAttribute<Shopping, Long> id;
	public static volatile SingularAttribute<Shopping, String> cidade;
	public static volatile SingularAttribute<Shopping, String> estado;
	public static volatile SingularAttribute<Shopping, String> logradouro;
	public static volatile SingularAttribute<Shopping, String> nome;
	public static volatile ListAttribute<Shopping, Loja> lojas;
	public static volatile SingularAttribute<Shopping, Integer> numero;

}

