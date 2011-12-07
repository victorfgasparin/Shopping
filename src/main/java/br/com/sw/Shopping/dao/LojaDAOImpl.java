/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sw.Shopping.dao;

import java.util.List;

import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.sw.Shopping.model.Loja;

/**
 *
 * @author renato
 */
@Stateful
public class LojaDAOImpl implements LojaDAO {
	
    @Inject
    EntityManager em;
    @Override
    public void adiciona(Loja loja) {
        em.persist(loja);
    }

    @Override
    public void remove(Loja loja) {
        em.remove(loja);
    }

    @Override
    public void atualiza(Loja loja) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Loja> listaNome() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Loja> listaAtividade() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Loja> listaOrdemAlfabetica() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public Loja buscaPorId(Long id) {
        return (Loja) em.find(Loja.class, id);
    }
    
    @Override
    public Loja buscaPorNome (String nome) {
        return (Loja) em.createQuery("select l from Loja l where "
                + "nome = " + nome).getSingleResult();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
}
