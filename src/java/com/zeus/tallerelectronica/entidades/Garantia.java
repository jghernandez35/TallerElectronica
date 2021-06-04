/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zeus.tallerelectronica.entidades;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "garantia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Garantia.findAll", query = "SELECT g FROM Garantia g")
    , @NamedQuery(name = "Garantia.findByGarId", query = "SELECT g FROM Garantia g WHERE g.garId = :garId")
    , @NamedQuery(name = "Garantia.findByGarNumfacturaalmacen", query = "SELECT g FROM Garantia g WHERE g.garNumfacturaalmacen = :garNumfacturaalmacen")
    , @NamedQuery(name = "Garantia.findByGarFechafacturaalmacen", query = "SELECT g FROM Garantia g WHERE g.garFechafacturaalmacen = :garFechafacturaalmacen")
    , @NamedQuery(name = "Garantia.findByGarNumordenmarca", query = "SELECT g FROM Garantia g WHERE g.garNumordenmarca = :garNumordenmarca")})
public class Garantia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "GAR_ID")
    private Integer garId;
    @Size(max = 30)
    @Column(name = "GAR_NUMFACTURAALMACEN")
    private String garNumfacturaalmacen;
    @Column(name = "GAR_FECHAFACTURAALMACEN")
    @Temporal(TemporalType.DATE)
    private Date garFechafacturaalmacen;
    @Size(max = 30)
    @Column(name = "GAR_NUMORDENMARCA")
    private String garNumordenmarca;
    @JoinColumn(name = "ALM_ID", referencedColumnName = "ALM_ID")
    @ManyToOne(optional = false)
    private Almacen almId;
    @JoinColumn(name = "REPA_ID_NUMORDEN", referencedColumnName = "REPA_ID_NUMORDEN")
    @ManyToOne(optional = false)
    private Reparacion repaIdNumorden;

    public Garantia() {
    }

    public Garantia(Integer garId) {
        this.garId = garId;
    }

    public Integer getGarId() {
        return garId;
    }

    public void setGarId(Integer garId) {
        this.garId = garId;
    }

    public String getGarNumfacturaalmacen() {
        return garNumfacturaalmacen;
    }

    public void setGarNumfacturaalmacen(String garNumfacturaalmacen) {
        this.garNumfacturaalmacen = garNumfacturaalmacen;
    }

    public Date getGarFechafacturaalmacen() {
        return garFechafacturaalmacen;
    }

    public void setGarFechafacturaalmacen(Date garFechafacturaalmacen) {
        this.garFechafacturaalmacen = garFechafacturaalmacen;
    }

    public String getGarNumordenmarca() {
        return garNumordenmarca;
    }

    public void setGarNumordenmarca(String garNumordenmarca) {
        this.garNumordenmarca = garNumordenmarca;
    }

    public Almacen getAlmId() {
        return almId;
    }

    public void setAlmId(Almacen almId) {
        this.almId = almId;
    }

    public Reparacion getRepaIdNumorden() {
        return repaIdNumorden;
    }

    public void setRepaIdNumorden(Reparacion repaIdNumorden) {
        this.repaIdNumorden = repaIdNumorden;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (garId != null ? garId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Garantia)) {
            return false;
        }
        Garantia other = (Garantia) object;
        if ((this.garId == null && other.garId != null) || (this.garId != null && !this.garId.equals(other.garId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zeus.tallerelectronica.entidades.Garantia[ garId=" + garId + " ]";
    }
    
}
