package br.com.sw.Shopping.model;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Categorias.class)
public abstract class Categorias_ {

	public static volatile SingularAttribute<Categorias, Long> id;
	public static volatile SingularAttribute<Categorias, String> nome;

}

