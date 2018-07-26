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
@Table(name = "estadosservicio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estadosservicio.findAll", query = "SELECT e FROM Estadosservicio e")
    , @NamedQuery(name = "Estadosservicio.findByEstId", query = "SELECT e FROM Estadosservicio e WHERE e.estId = :estId")
    , @NamedQuery(name = "Estadosservicio.findByEstNombre", query = "SELECT e FROM Estadosservicio e WHERE e.estNombre = :estNombre")
    , @NamedQuery(name = "Estadosservicio.findByEstEstado", query = "SELECT e FROM Estadosservicio e WHERE e.estEstado = :estEstado")})
public class Estadosservicio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "EST_ID")
    private Integer estId;
    @Size(max = 40)
    @Column(name = "EST_NOMBRE")
    private String estNombre;
    @Column(name = "EST_ESTADO")
    private Integer estEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estId")
    private Collection<Reparacion> reparacionCollection;

    public Estadosservicio() {
    }

    public Estadosservicio(Integer estId) {
        this.estId = estId;
    }

    public Integer getEstId() {
        return estId;
    }

    public void setEstId(Integer estId) {
        this.estId = estId;
    }

    public String getEstNombre() {
        return estNombre;
    }

    public void setEstNombre(String estNombre) {
        this.estNombre = estNombre;
    }

    public Integer getEstEstado() {
        return estEstado;
    }

    public void setEstEstado(Integer estEstado) {
        this.estEstado = estEstado;
    }

    @XmlTransient
    public Collection<Reparacion> getReparacionCollection() {
        return reparacionCollection;
    }

    public void setReparacionCollection(Collection<Reparacion> reparacionCollection) {
        this.reparacionCollection = reparacionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estId != null ? estId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estadosservicio)) {
            return false;
        }
        Estadosservicio other = (Estadosservicio) object;
        if ((this.estId == null && other.estId != null) || (this.estId != null && !this.estId.equals(other.estId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tallerelectronica.entidades.Estadosservicio[ estId=" + estId + " ]";
    }
    
}
