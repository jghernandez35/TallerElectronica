/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tallerelectronica.entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author AcerF5w10
 */
@Entity
@Table(name = "articulo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Articulo.findAll", query = "SELECT a FROM Articulo a")
    , @NamedQuery(name = "Articulo.findByArtIdNumorden", query = "SELECT a FROM Articulo a WHERE a.artIdNumorden = :artIdNumorden")
    , @NamedQuery(name = "Articulo.findByArtModelo", query = "SELECT a FROM Articulo a WHERE a.artModelo = :artModelo")
    , @NamedQuery(name = "Articulo.findByArtSerial", query = "SELECT a FROM Articulo a WHERE a.artSerial = :artSerial")
    , @NamedQuery(name = "Articulo.findByArtGarantia", query = "SELECT a FROM Articulo a WHERE a.artGarantia = :artGarantia")
    , @NamedQuery(name = "Articulo.findByCliId", query = "SELECT a FROM Articulo a WHERE a.cliId.cliId = :cliId ")
    , @NamedQuery(name = "Articulo.findByArtFechaingreso", query = "SELECT a FROM Articulo a WHERE a.artFechaingreso = :artFechaingreso")})
public class Articulo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ART_ID_NUMORDEN")
    private Integer artIdNumorden;
    @Size(max = 50)
    @Column(name = "ART_MODELO")
    private String artModelo;
    @Size(max = 50)
    @Column(name = "ART_SERIAL")
    private String artSerial;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "ART_FALLA")
    private String artFalla;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "ART_ACCESORIOS")
    private String artAccesorios;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "ART_OBSERVACIONES")
    private String artObservaciones;
    @Size(max = 20)
    @Column(name = "ART_GARANTIA")
    private String artGarantia;
    @Column(name = "ART_FECHAINGRESO")
    @Temporal(TemporalType.DATE)
    private Date artFechaingreso;
    @ManyToMany(mappedBy = "articuloCollection")
    private Collection<Tecnico> tecnicoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "artIdNumorden")
    private Collection<Reparacion> reparacionCollection;
    @JoinColumn(name = "MAR_ID_MARCA", referencedColumnName = "MAR_ID_MARCA")
    @ManyToOne(optional = false)
    private Marca marIdMarca;
    @JoinColumn(name = "TIP_ID_TIPO_ARTICULO", referencedColumnName = "TIP_ID_TIPO_ARTICULO")
    @ManyToOne(optional = false)
    private Tipoarticulo tipIdTipoArticulo;
    @JoinColumn(name = "CLI_ID", referencedColumnName = "CLI_ID")
    @ManyToOne(optional = false)
    private Cliente cliId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "artIdNumorden")
    private Collection<Garantia> garantiaCollection;

    public Articulo() {
    }

    public Articulo(Integer artIdNumorden) {
        this.artIdNumorden = artIdNumorden;
    }

    public Integer getArtIdNumorden() {
        return artIdNumorden;
    }

    public void setArtIdNumorden(Integer artIdNumorden) {
        this.artIdNumorden = artIdNumorden;
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

    public String getArtFalla() {
        return artFalla;
    }

    public void setArtFalla(String artFalla) {
        this.artFalla = artFalla;
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

    public String getArtGarantia() {
        return artGarantia;
    }

    public void setArtGarantia(String artGarantia) {
        this.artGarantia = artGarantia;
    }

    public Date getArtFechaingreso() {
        return artFechaingreso;
    }

    public void setArtFechaingreso(Date artFechaingreso) {
        this.artFechaingreso = artFechaingreso;
    }

    @XmlTransient
    public Collection<Tecnico> getTecnicoCollection() {
        return tecnicoCollection;
    }

    public void setTecnicoCollection(Collection<Tecnico> tecnicoCollection) {
        this.tecnicoCollection = tecnicoCollection;
    }

    @XmlTransient
    public Collection<Reparacion> getReparacionCollection() {
        return reparacionCollection;
    }

    public void setReparacionCollection(Collection<Reparacion> reparacionCollection) {
        this.reparacionCollection = reparacionCollection;
    }

    public Marca getMarIdMarca() {
        return marIdMarca;
    }

    public void setMarIdMarca(Marca marIdMarca) {
        this.marIdMarca = marIdMarca;
    }

    public Tipoarticulo getTipIdTipoArticulo() {
        return tipIdTipoArticulo;
    }

    public void setTipIdTipoArticulo(Tipoarticulo tipIdTipoArticulo) {
        this.tipIdTipoArticulo = tipIdTipoArticulo;
    }

    public Cliente getCliId() {
        return cliId;
    }

    public void setCliId(Cliente cliId) {
        this.cliId = cliId;
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
        hash += (artIdNumorden != null ? artIdNumorden.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Articulo)) {
            return false;
        }
        Articulo other = (Articulo) object;
        if ((this.artIdNumorden == null && other.artIdNumorden != null) || (this.artIdNumorden != null && !this.artIdNumorden.equals(other.artIdNumorden))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tallerelectronica.entidades.Articulo[ artIdNumorden=" + artIdNumorden + " ]";
    }
    
}
