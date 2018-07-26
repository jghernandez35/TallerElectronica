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
@Table(name = "almacen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Almacen.findAll", query = "SELECT a FROM Almacen a")
    , @NamedQuery(name = "Almacen.findByAlmId", query = "SELECT a FROM Almacen a WHERE a.almId = :almId")
    , @NamedQuery(name = "Almacen.findByAlmNombre", query = "SELECT a FROM Almacen a WHERE a.almNombre = :almNombre")
    , @NamedQuery(name = "Almacen.findByAlmEstado", query = "SELECT a FROM Almacen a WHERE a.almEstado = :almEstado")})
public class Almacen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ALM_ID")
    private Integer almId;
    @Size(max = 60)
    @Column(name = "ALM_NOMBRE")
    private String almNombre;
    @Column(name = "ALM_ESTADO")
    private Integer almEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "almId")
    private Collection<Garantia> garantiaCollection;

    public Almacen() {
    }

    public Almacen(Integer almId) {
        this.almId = almId;
    }

    public Integer getAlmId() {
        return almId;
    }

    public void setAlmId(Integer almId) {
        this.almId = almId;
    }

    public String getAlmNombre() {
        return almNombre;
    }

    public void setAlmNombre(String almNombre) {
        this.almNombre = almNombre;
    }

    public Integer getAlmEstado() {
        return almEstado;
    }

    public void setAlmEstado(Integer almEstado) {
        this.almEstado = almEstado;
    }

    @XmlTransient
    public Collection<Garantia> getGarantiaCollection() {
        return garantiaCollection;
    }

    public void setGarantiaCollection(Collection<Garantia> garantiaCollection) {
        this.garantiaCollection = garantiaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (almId != null ? almId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Almacen)) {
            return false;
        }
        Almacen other = (Almacen) object;
        if ((this.almId == null && other.almId != null) || (this.almId != null && !this.almId.equals(other.almId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tallerelectronica.entidades.Almacen[ almId=" + almId + " ]";
    }
    
}
