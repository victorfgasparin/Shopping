package br.com.sw.Shopping.data;

import br.com.sw.Shopping.model.Loja;

public class LojasMenu {

	private Loja loja;
	private String caminho;
    private String imagem;
    
	public LojasMenu(Loja loja) {
		super();
		this.loja = loja;
		
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
	}

	public Loja getLoja() {
		return loja;
	}

	public String getCaminho() {
		return caminho;
	}

	public String getImagem() {
		return imagem;
	}
	
	public String getNome(){
		return loja.getNome();
	}
	
	public Long getId(){
		return loja.getId();
	}
	
	public String getLogo(){
		return loja.getLogo();
	}
	
	public String  getDescricao(){
		return loja.getDescricao();
	}
	
	
}
