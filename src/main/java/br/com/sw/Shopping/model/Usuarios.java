package br.com.sw.Shopping.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
/**
 *
 * @author racruz
 */
@Entity
@Table
public class Usuarios implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    @Size(max = 60)
    @Column
    private String nome;
    @NotNull
    @Size(max = 10)
    @Column
    private String senha;
    @OneToMany(mappedBy="usuario")
    private List <Compras> usuariosCompras;

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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Compras> getUsuariosCompras() {
        return usuariosCompras;
    }

    public void setUsuariosCompras(List<Compras> usuariosCompras) {
        this.usuariosCompras = usuariosCompras;
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
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Usuarios[ idUsuarios=" + id + " ]";
    }
}
