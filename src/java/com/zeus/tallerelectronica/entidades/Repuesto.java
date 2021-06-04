/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zeus.tallerelectronica.entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "repuesto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Repuesto.findAll", query = "SELECT r FROM Repuesto r")
    , @NamedQuery(name = "Repuesto.findByRepuId", query = "SELECT r FROM Repuesto r WHERE r.repuId = :repuId")
    , @NamedQuery(name = "Repuesto.findByRepuNumparte", query = "SELECT r FROM Repuesto r WHERE r.repuNumparte = :repuNumparte")
    , @NamedQuery(name = "Repuesto.findByRepuCantidad", query = "SELECT r FROM Repuesto r WHERE r.repuCantidad = :repuCantidad")
    , @NamedQuery(name = "Repuesto.findByRepuDescripcion", query = "SELECT r FROM Repuesto r WHERE r.repuDescripcion = :repuDescripcion")
    , @NamedQuery(name = "Repuesto.findByRepuPrecio", query = "SELECT r FROM Repuesto r WHERE r.repuPrecio = :repuPrecio")})
public class Repuesto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "REPU_ID")
    private Integer repuId;
    @Size(max = 30)
    @Column(name = "REPU_NUMPARTE")
    private String repuNumparte;
    @Column(name = "REPU_CANTIDAD")
    private Integer repuCantidad;
    @Size(max = 40)
    @Column(name = "REPU_DESCRIPCION")
    private String repuDescripcion;
    @Column(name = "REPU_PRECIO")
    private Integer repuPrecio;
    @JoinTable(name = "tiene_asociados_repuesto", joinColumns = {
        @JoinColumn(name = "REPU_ID", referencedColumnName = "REPU_ID")}, inverseJoinColumns = {
        @JoinColumn(name = "REPA_ID_NUMORDEN", referencedColumnName = "REPA_ID_NUMORDEN")})
    @ManyToMany
    private Collection<Reparacion> reparacionCollection;
    @JoinColumn(name = "TIPOREPU_ID", referencedColumnName = "TIPOREPU_ID")
    @ManyToOne(optional = false)
    private Tiporepuesto tiporepuId;

    public Repuesto() {
    }

    public Repuesto(Integer repuId) {
        this.repuId = repuId;
    }

    public Integer getRepuId() {
        return repuId;
    }

    public void setRepuId(Integer repuId) {
        this.repuId = repuId;
    }

    public String getRepuNumparte() {
        return repuNumparte;
    }

    public void setRepuNumparte(String repuNumparte) {
        this.repuNumparte = repuNumparte;
    }

    public Integer getRepuCantidad() {
        return repuCantidad;
    }

    public void setRepuCantidad(Integer repuCantidad) {
        this.repuCantidad = repuCantidad;
    }

    public String getRepuDescripcion() {
        return repuDescripcion;
    }

    public void setRepuDescripcion(String repuDescripcion) {
        this.repuDescripcion = repuDescripcion;
    }

    public Integer getRepuPrecio() {
        return repuPrecio;
    }

    public void setRepuPrecio(Integer repuPrecio) {
        this.repuPrecio = repuPrecio;
    }

    @XmlTransient
    public Collection<Reparacion> getReparacionCollection() {
        return reparacionCollection;
    }

    public void setReparacionCollection(Collection<Reparacion> reparacionCollection) {
        this.reparacionCollection = reparacionCollection;
    }

    public Tiporepuesto getTiporepuId() {
        return tiporepuId;
    }

    public void setTiporepuId(Tiporepuesto tiporepuId) {
        this.tiporepuId = tiporepuId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (repuId != null ? repuId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Repuesto)) {
            return false;
        }
        Repuesto other = (Repuesto) object;
        if ((this.repuId == null && other.repuId != null) || (this.repuId != null && !this.repuId.equals(other.repuId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zeus.tallerelectronica.entidades.Repuesto[ repuId=" + repuId + " ]";
    }
    
}
