/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zeus.tallerelectronica.entidades;

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
@Table(name = "tipoarticulo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipoarticulo.findAll", query = "SELECT t FROM Tipoarticulo t")
    , @NamedQuery(name = "Tipoarticulo.findByTipartId", query = "SELECT t FROM Tipoarticulo t WHERE t.tipartId = :tipartId")
    , @NamedQuery(name = "Tipoarticulo.findByTipartNombre", query = "SELECT t FROM Tipoarticulo t WHERE t.tipartNombre = :tipartNombre")
    , @NamedQuery(name = "Tipoarticulo.findByTipartEstado", query = "SELECT t FROM Tipoarticulo t WHERE t.tipartEstado = :tipartEstado")})
public class Tipoarticulo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TIPART_ID")
    private Integer tipartId;
    @Size(max = 30)
    @Column(name = "TIPART_NOMBRE")
    private String tipartNombre;
    @Column(name = "TIPART_ESTADO")
    private Integer tipartEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipartId")
    private Collection<Articulo> articuloCollection;

    public Tipoarticulo() {
    }

    public Tipoarticulo(Integer tipartId) {
        this.tipartId = tipartId;
    }

    public Integer getTipartId() {
        return tipartId;
    }

    public void setTipartId(Integer tipartId) {
        this.tipartId = tipartId;
    }

    public String getTipartNombre() {
        return tipartNombre;
    }

    public void setTipartNombre(String tipartNombre) {
        this.tipartNombre = tipartNombre;
    }

    public Integer getTipartEstado() {
        return tipartEstado;
    }

    public void setTipartEstado(Integer tipartEstado) {
        this.tipartEstado = tipartEstado;
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
        hash += (tipartId != null ? tipartId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipoarticulo)) {
            return false;
        }
        Tipoarticulo other = (Tipoarticulo) object;
        if ((this.tipartId == null && other.tipartId != null) || (this.tipartId != null && !this.tipartId.equals(other.tipartId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zeus.tallerelectronica.entidades.Tipoarticulo[ tipartId=" + tipartId + " ]";
    }
    
}
