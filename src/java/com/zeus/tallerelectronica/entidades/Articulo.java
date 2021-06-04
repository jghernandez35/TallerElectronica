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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "articulo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Articulo.findAll", query = "SELECT a FROM Articulo a")
    , @NamedQuery(name = "Articulo.findByArtId", query = "SELECT a FROM Articulo a WHERE a.artId = :artId")
    , @NamedQuery(name = "Articulo.findByArtModelo", query = "SELECT a FROM Articulo a WHERE a.artModelo = :artModelo")
    , @NamedQuery(name = "Articulo.findByArtSerial", query = "SELECT a FROM Articulo a WHERE a.artSerial = :artSerial")})
public class Articulo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ART_ID")
    private Integer artId;
    @Size(max = 50)
    @Column(name = "ART_MODELO")
    private String artModelo;
    @Size(max = 50)
    @Column(name = "ART_SERIAL")
    private String artSerial;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "ART_ACCESORIOS")
    private String artAccesorios;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "ART_OBSERVACIONES")
    private String artObservaciones;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "artId")
    private Collection<Reparacion> reparacionCollection;
    @JoinColumn(name = "MAR_ID", referencedColumnName = "MAR_ID")
    @ManyToOne(optional = false)
    private Marca marId;
    @JoinColumn(name = "TIPART_ID", referencedColumnName = "TIPART_ID")
    @ManyToOne(optional = false)
    private Tipoarticulo tipartId;

    public Articulo() {
    }

    public Articulo(Integer artId) {
        this.artId = artId;
    }

    public Integer getArtId() {
        return artId;
    }

    public void setArtId(Integer artId) {
        this.artId = artId;
    }

    public String getArtModelo() {
        return artModelo;
    }

    public void setArtModelo(String artModelo) {
        this.artModelo = artModelo;
    }

    public String getArtSerial() {
        return artSerial;
    }

    public void setArtSerial(String artSerial) {
        this.artSerial = artSerial;
    }

    public String getArtAccesorios() {
        return artAccesorios;
    }

    public void setArtAccesorios(String artAccesorios) {
        this.artAccesorios = artAccesorios;
    }

    public String getArtObservaciones() {
        return artObservaciones;
    }

    public void setArtObservaciones(String artObservaciones) {
        this.artObservaciones = artObservaciones;
    }

    @XmlTransient
    public Collection<Reparacion> getReparacionCollection() {
        return reparacionCollection;
    }

    public void setReparacionCollection(Collection<Reparacion> reparacionCollection) {
        this.reparacionCollection = reparacionCollection;
    }

    public Marca getMarId() {
        return marId;
    }

    public void setMarId(Marca marId) {
        this.marId = marId;
    }

    public Tipoarticulo getTipartId() {
        return tipartId;
    }

    public void setTipartId(Tipoarticulo tipartId) {
        this.tipartId = tipartId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (artId != null ? artId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Articulo)) {
            return false;
        }
        Articulo other = (Articulo) object;
        if ((this.artId == null && other.artId != null) || (this.artId != null && !this.artId.equals(other.artId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zeus.tallerelectronica.entidades.Articulo[ artId=" + artId + " ]";
    }
    
}
