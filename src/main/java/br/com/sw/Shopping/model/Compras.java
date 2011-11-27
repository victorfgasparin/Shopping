package br.com.sw.Shopping.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
/**
 *
 * @author racruz
 */
@Entity
@Table
public class Compras implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private Long id;
    @Temporal(TemporalType.DATE)
    @Column
    @NotNull
    private Calendar dataCompra;
    @Column
    private Integer formaPagamento;
    @Column
    private String numeroCartao;
    @Column
    private String codigoSeguranca;
    @Column
    private Integer bandeiraCartao;
    @ManyToOne
    private Usuarios usuario;
    @OneToMany(mappedBy="compra")
    private List<ProdutosCompra> produtosCompras;

    public Integer getBandeiraCartao() {
        return bandeiraCartao;
    }

    public void setBandeiraCartao(Integer bandeiraCartao) {
        this.bandeiraCartao = bandeiraCartao;
    }

    public String getCodigoSeguranca() {
        return codigoSeguranca;
    }

    public void setCodigoSeguranca(String codigoSeguranca) {
        this.codigoSeguranca = codigoSeguranca;
    }

    public Calendar getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Calendar dataCompra) {
        this.dataCompra = dataCompra;
    }

    public Integer getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(Integer formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
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
        if (!(object instanceof Compras)) {
            return false;
        }
        Compras other = (Compras) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Compras[ idCompras=" + id + " ]";
    }

	public Usuarios getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}

	public List<ProdutosCompra> getProdutosCompras() {
		return produtosCompras;
	}

	public void setProdutosCompras(List<ProdutosCompra> produtosCompras) {
		this.produtosCompras = produtosCompras;
	}
}
