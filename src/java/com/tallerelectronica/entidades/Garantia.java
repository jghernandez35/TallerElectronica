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
@Table(name = "garantia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Garantia.findAll", query = "SELECT g FROM Garantia g")
    , @NamedQuery(name = "Garantia.findByGarId", query = "SELECT g FROM Garantia g WHERE g.garId = :garId")
    , @NamedQuery(name = "Garantia.findByGarIdNumordenalmacen", query = "SELECT g FROM Garantia g WHERE g.garIdNumordenalmacen = :garIdNumordenalmacen")})
public class Garantia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "GAR_ID")
    private Integer garId;
    @Size(max = 40)
    @Column(name = "GAR_ID_NUMORDENALMACEN")
    private String garIdNumordenalmacen;
    @JoinColumn(name = "ART_ID_NUMORDEN", referencedColumnName = "ART_ID_NUMORDEN")
    @ManyToOne(optional = false)
    private Articulo artIdNumorden;
    @JoinColumn(name = "ALM_ID", referencedColumnName = "ALM_ID")
    @ManyToOne(optional = false)
    private Almacen almId;

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

    public String getGarIdNumordenalmacen() {
        return garIdNumordenalmacen;
    }

    public void setGarIdNumordenalmacen(String garIdNumordenalmacen) {
        this.garIdNumordenalmacen = garIdNumordenalmacen;
    }

    public Articulo getArtIdNumorden() {
        return artIdNumorden;
    }

    public void setArtIdNumorden(Articulo artIdNumorden) {
        this.artIdNumorden = artIdNumorden;
    }

    public Almacen getAlmId() {
        return almId;
    }

    public void setAlmId(Almacen almId) {
        this.almId = almId;
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
        return "com.tallerelectronica.entidades.Garantia[ garId=" + garId + " ]";
    }
    
}
