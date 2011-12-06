package br.com.sw.Shopping.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author racruz
 */
@Entity
@Table
public class Produtos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String nome;
    @Column
    private String imagem;
    @Column(length=5000)
    private String descricao;
    @Column
    private Integer quantidade;
    @Column
    private Double precoVenda;
    @Column
    private Double porcentagemPromocao;
    
    @ManyToMany
    @JoinTable(name="CategoriasProduto")
    private List<Categorias> categorias;
    @ManyToOne
    private Loja loja;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produtos)) {
            return false;
        }
        Produtos other = (Produtos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ProdutosCompra[ idProdutosCompra=" + id + " ]";
    }

	public Loja getLoja() {
		return loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}

	public List<Categorias> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categorias> categorias) {
		this.categorias = categorias;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public Double getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(Double precoVenda) {
		this.precoVenda = precoVenda;
	}

	@Transient
	public Double getPrecoComPromocao() {
		if (temPromocao())
			return precoVenda * (1-porcentagemPromocao);
		return precoVenda;
	}

	@Transient
	private boolean temPromocao() {
		return porcentagemPromocao != null && porcentagemPromocao > 0;
	}

	public Double getPorcentagemPromocao() {
		return porcentagemPromocao;
	}

	public void setPorcentagemPromocao(Double porcentagemPromocao) {
		this.porcentagemPromocao = porcentagemPromocao;
	}

	@Transient
	public boolean ehOmesmo(Produtos produto) {
		return produto.getId().equals(this.id);
	}

}
