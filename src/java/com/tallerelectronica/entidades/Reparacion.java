/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tallerelectronica.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author AcerF5w10
 */
@Entity
@Table(name = "reparacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reparacion.findAll", query = "SELECT r FROM Reparacion r")
    , @NamedQuery(name = "Reparacion.findByRepId", query = "SELECT r FROM Reparacion r WHERE r.repId = :repId")
    , @NamedQuery(name = "Reparacion.findByRepReportetecnico", query = "SELECT r FROM Reparacion r WHERE r.repReportetecnico = :repReportetecnico")
    , @NamedQuery(name = "Reparacion.findByRepPrecio", query = "SELECT r FROM Reparacion r WHERE r.repPrecio = :repPrecio")})
public class Reparacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "REP_ID")
    private Integer repId;
    @Size(max = 1200)
    @Column(name = "REP_REPORTETECNICO")
    private String repReportetecnico;
    @Column(name = "REP_PRECIO")
    private Integer repPrecio;
    @JoinColumn(name = "EST_ID", referencedColumnName = "EST_ID")
    @ManyToOne(optional = false)
    private Estadosservicio estId;
    @JoinColumn(name = "ART_ID_NUMORDEN", referencedColumnName = "ART_ID_NUMORDEN")
    @ManyToOne(optional = false)
    private Articulo artIdNumorden;

    public Reparacion() {
    }

    public Reparacion(Integer repId) {
        this.repId = repId;
    }

    public Integer getRepId() {
        return repId;
    }

    public void setRepId(Integer repId) {
        this.repId = repId;
    }

    public String getRepReportetecnico() {
        return repReportetecnico;
    }

    public void setRepReportetecnico(String repReportetecnico) {
        this.repReportetecnico = repReportetecnico;
    }

    public Integer getRepPrecio() {
        return repPrecio;
    }

    public void setRepPrecio(Integer repPrecio) {
        this.repPrecio = repPrecio;
    }

    public Estadosservicio getEstId() {
        return estId;
    }

    public void setEstId(Estadosservicio estId) {
        this.estId = estId;
    }

    public Articulo getArtIdNumorden() {
        return artIdNumorden;
    }

    public void setArtIdNumorden(Articulo artIdNumorden) {
        this.artIdNumorden = artIdNumorden;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (repId != null ? repId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reparacion)) {
            return false;
        }
        Reparacion other = (Reparacion) object;
        if ((this.repId == null && other.repId != null) || (this.repId != null && !this.repId.equals(other.repId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tallerelectronica.entidades.Reparacion[ repId=" + repId + " ]";
    }
    
}
