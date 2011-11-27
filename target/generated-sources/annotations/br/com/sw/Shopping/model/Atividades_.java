package br.com.sw.Shopping.model;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Atividades.class)
public abstract class Atividades_ {

	public static volatile SingularAttribute<Atividades, Long> id;
	public static volatile SingularAttribute<Atividades, String> nome;

}

