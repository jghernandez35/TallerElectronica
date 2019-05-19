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
@Table(name = "tiporepuesto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tiporepuesto.findAll", query = "SELECT t FROM Tiporepuesto t")
    , @NamedQuery(name = "Tiporepuesto.findByTiporepuId", query = "SELECT t FROM Tiporepuesto t WHERE t.tiporepuId = :tiporepuId")
    , @NamedQuery(name = "Tiporepuesto.findByTiporepuNombre", query = "SELECT t FROM Tiporepuesto t WHERE t.tiporepuNombre = :tiporepuNombre")
    , @NamedQuery(name = "Tiporepuesto.findByTiporepuEstado", query = "SELECT t FROM Tiporepuesto t WHERE t.tiporepuEstado = :tiporepuEstado")})
public class Tiporepuesto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TIPOREPU_ID")
    private Integer tiporepuId;
    @Size(max = 30)
    @Column(name = "TIPOREPU_NOMBRE")
    private String tiporepuNombre;
    @Column(name = "TIPOREPU_ESTADO")
    private Integer tiporepuEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tiporepuId")
    private Collection<Repuesto> repuestoCollection;

    public Tiporepuesto() {
    }

    public Tiporepuesto(Integer tiporepuId) {
        this.tiporepuId = tiporepuId;
    }

    public Integer getTiporepuId() {
        return tiporepuId;
    }

    public void setTiporepuId(Integer tiporepuId) {
        this.tiporepuId = tiporepuId;
    }

    public String getTiporepuNombre() {
        return tiporepuNombre;
    }

    public void setTiporepuNombre(String tiporepuNombre) {
        this.tiporepuNombre = tiporepuNombre;
    }

    public Integer getTiporepuEstado() {
        return tiporepuEstado;
    }

    public void setTiporepuEstado(Integer tiporepuEstado) {
        this.tiporepuEstado = tiporepuEstado;
    }

    @XmlTransient
    public Collection<Repuesto> getRepuestoCollection() {
        return repuestoCollection;
    }

    public void setRepuestoCollection(Collection<Repuesto> repuestoCollection) {
        this.repuestoCollection = repuestoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tiporepuId != null ? tiporepuId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tiporepuesto)) {
            return false;
        }
        Tiporepuesto other = (Tiporepuesto) object;
        if ((this.tiporepuId == null && other.tiporepuId != null) || (this.tiporepuId != null && !this.tiporepuId.equals(other.tiporepuId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zeus.tallerelectronica.entidades.Tiporepuesto[ tiporepuId=" + tiporepuId + " ]";
    }
    
}
