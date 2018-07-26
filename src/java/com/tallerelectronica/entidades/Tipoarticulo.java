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
@Table(name = "tipoarticulo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipoarticulo.findAll", query = "SELECT t FROM Tipoarticulo t")
    , @NamedQuery(name = "Tipoarticulo.findByTipIdTipoArticulo", query = "SELECT t FROM Tipoarticulo t WHERE t.tipIdTipoArticulo = :tipIdTipoArticulo")
    , @NamedQuery(name = "Tipoarticulo.findByTipNombre", query = "SELECT t FROM Tipoarticulo t WHERE t.tipNombre = :tipNombre")
    , @NamedQuery(name = "Tipoarticulo.findByTipEstado", query = "SELECT t FROM Tipoarticulo t WHERE t.tipEstado = :tipEstado")})
public class Tipoarticulo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TIP_ID_TIPO_ARTICULO")
    private Integer tipIdTipoArticulo;
    @Size(max = 30)
    @Column(name = "TIP_NOMBRE")
    private String tipNombre;
    @Column(name = "TIP_ESTADO")
    private Integer tipEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipIdTipoArticulo")
    private Collection<Articulo> articuloCollection;

    public Tipoarticulo() {
    }

    public Tipoarticulo(Integer tipIdTipoArticulo) {
        this.tipIdTipoArticulo = tipIdTipoArticulo;
    }

    public Integer getTipIdTipoArticulo() {
        return tipIdTipoArticulo;
    }

    public void setTipIdTipoArticulo(Integer tipIdTipoArticulo) {
        this.tipIdTipoArticulo = tipIdTipoArticulo;
    }

    public String getTipNombre() {
        return tipNombre;
    }

    public void setTipNombre(String tipNombre) {
        this.tipNombre = tipNombre;
    }

    public Integer getTipEstado() {
        return tipEstado;
    }

    public void setTipEstado(Integer tipEstado) {
        this.tipEstado = tipEstado;
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
        hash += (tipIdTipoArticulo != null ? tipIdTipoArticulo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipoarticulo)) {
            return false;
        }
        Tipoarticulo other = (Tipoarticulo) object;
        if ((this.tipIdTipoArticulo == null && other.tipIdTipoArticulo != null) || (this.tipIdTipoArticulo != null && !this.tipIdTipoArticulo.equals(other.tipIdTipoArticulo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tallerelectronica.entidades.Tipoarticulo[ tipIdTipoArticulo=" + tipIdTipoArticulo + " ]";
    }
    
}
