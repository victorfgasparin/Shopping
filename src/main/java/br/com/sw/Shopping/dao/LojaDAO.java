/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sw.Shopping.dao;

import java.util.List;

import javax.ejb.Local;

import br.com.sw.Shopping.model.Loja;

/**
 *
 * @author renato
 */
@Local
public interface LojaDAO {
    public void adiciona (Loja loja);
    
    public void remove (Loja loja);
    
    public void atualiza (Loja loja);
    
    public List<Loja> listaNome();
    
    public List<Loja> listaAtividade();
    
    public List<Loja> listaOrdemAlfabetica();

    public Loja buscaPorNome(String nomeLoja);
    
    public Loja buscaPorId(Long id);
}
