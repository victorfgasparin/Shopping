/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sw.Shopping.controller;

import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.sw.Shopping.controller.CarrinhoDeCompras.ItensDeCompra;
import br.com.sw.Shopping.dao.LojaDAO;
import br.com.sw.Shopping.model.Loja;
import br.com.sw.Shopping.model.Produtos;

/**
 *
 * @author renato
 */
@Named
@SessionScoped
@Stateful
public class LocalizaLojaMBean {

    @Inject
    private LojaDAO dao;
    
    private Loja loja;
    private String nomeLoja;
    private String caminho;
    private String imagem;
    /** Creates a new instance of LocalizaLojaMBean */
    public LocalizaLojaMBean() {
    }

    public String getNomeLoja() {
        return nomeLoja;
    }

    public void setNomeLoja(String nomeLoja) {
        this.nomeLoja = nomeLoja;
    }

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    
    public void localizarLoja() {
        try {
            //loja = dao.buscaPorNome(nomeLoja);
            if (loja.getLocalizacao().equals("A")) {
                caminho = "Seção A, lojas Ã  esquerda";
                imagem = "A.png";
            } else if (loja.getLocalizacao().equals("B")) {
                caminho = "Seção B, lojas em frente";
                imagem = "B.png";
            } else {
                caminho = "Seção C, lojas Ã  direita";
                imagem = "C.png";
            } 
        } catch (Exception e) {
        }
    }
    
    public void adicionaCarrinho(@Observes final Loja lojaSelecionada) {
    	this.loja = lojaSelecionada;
    	localizarLoja();
	}
    
}
