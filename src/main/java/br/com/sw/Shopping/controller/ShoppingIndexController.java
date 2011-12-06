package br.com.sw.Shopping.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@SessionScoped
@Named("galeriaShopping")
@Stateful
public class ShoppingIndexController {

	private List<String> imagens;  
	  
    private String efeito = "slide";  
  
    @PostConstruct  
    public void init() {  
        imagens = new ArrayList<String>();  
  
        for(int i=1;i<=6;i++) {  
            imagens.add("shopping" + i + ".jpeg");  
        }  
    }  

    public List<String> getImagens() {  
        return imagens;  
    }  
  
    public String getEfeito() {  
        return efeito;  
    }  
}
