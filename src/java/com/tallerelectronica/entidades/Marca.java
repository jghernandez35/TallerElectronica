/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tallerelectronica.entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author AcerF5w10
 */
@Entity
@Table(name = "marca")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Marca.findAll", query = "SELECT m FROM Marca m")
    , @NamedQuery(name = "Marca.findByMarIdMarca", query = "SELECT m FROM Marca m WHERE m.marIdMarca = :marIdMarca")
    , @NamedQuery(name = "Marca.findByMarNombre", query = "SELECT m FROM Marca m WHERE m.marNombre = :marNombre")
    , @NamedQuery(name = "Marca.findByMarEstado", query = "SELECT m FROM Marca m WHERE m.marEstado = :marEstado")})
public class Marca implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MAR_ID_MARCA")
    private Integer marIdMarca;
    @Size(max = 30)
    @Column(name = "MAR_NOMBRE")
    private String marNombre;
    @Column(name = "MAR_ESTADO")
    private Integer marEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "marIdMarca")
    private Collection<Articulo> articuloCollection;

    public Marca() {
    }

    public Marca(Integer marIdMarca) {
        this.marIdMarca = marIdMarca;
    }

    public Integer getMarIdMarca() {
        return marIdMarca;
    }

    public void setMarIdMarca(Integer marIdMarca) {
        this.marIdMarca = marIdMarca;
    }

    public String getMarNombre() {
        return marNombre;
    }

    public void setMarNombre(String marNombre) {
        this.marNombre = marNombre;
    }

    public Integer getMarEstado() {
        return marEstado;
    }

    public void setMarEstado(Integer marEstado) {
        this.marEstado = marEstado;
    }

    @XmlTransient
    public Collection<Articulo> getArticuloCollection() {
        return articuloCollection;
    }

    public void setArticuloCollection(Collection<Articulo> articuloCollection) {
        this.articuloCollection = articuloCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (marIdMarca != null ? marIdMarca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Marca)) {
            return false;
        }
        Marca other = (Marca) object;
        if ((this.marIdMarca == null && other.marIdMarca != null) || (this.marIdMarca != null && !this.marIdMarca.equals(other.marIdMarca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tallerelectronica.entidades.Marca[ marIdMarca=" + marIdMarca + " ]";
    }
    
}
