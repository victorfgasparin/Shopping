package br.com.sw.Shopping.model;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Usuarios.class)
public abstract class Usuarios_ {

	public static volatile SingularAttribute<Usuarios, Long> id;
	public static volatile ListAttribute<Usuarios, Compras> usuariosCompras;
	public static volatile SingularAttribute<Usuarios, String> nome;
	public static volatile SingularAttribute<Usuarios, String> senha;

}

