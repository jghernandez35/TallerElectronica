/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zeus.tallerelectronica.entidades;

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
@Table(name = "reparacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reparacion.findAll", query = "SELECT r FROM Reparacion r")
    , @NamedQuery(name = "Reparacion.findByRepaIdNumorden", query = "SELECT r FROM Reparacion r WHERE r.repaIdNumorden = :repaIdNumorden")
    , @NamedQuery(name = "Reparacion.findByRepaFechaingreso", query = "SELECT r FROM Reparacion r WHERE r.repaFechaingreso = :repaFechaingreso")
    , @NamedQuery(name = "Reparacion.findByRepaFechasalida", query = "SELECT r FROM Reparacion r WHERE r.repaFechasalida = :repaFechasalida")
    , @NamedQuery(name = "Reparacion.findByRepaReportetecnico", query = "SELECT r FROM Reparacion r WHERE r.repaReportetecnico = :repaReportetecnico")
    , @NamedQuery(name = "Reparacion.findByRepaPreciomanoobra", query = "SELECT r FROM Reparacion r WHERE r.repaPreciomanoobra = :repaPreciomanoobra")})
public class Reparacion implements Serializable {

    @Size(max = 15)
    @Column(name = "REPA_TIPO")
    private String repaTipo;

    @Size(max = 1200)
    @Column(name = "REPA_REPORTECLIENTE")
    private String repaReportecliente;
    @Column(name = "REPA_ESTADO")
    private Integer repaEstado;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "REPA_ID_NUMORDEN")
    private Integer repaIdNumorden;
    @Column(name = "REPA_FECHAINGRESO")
    @Temporal(TemporalType.DATE)
    private Date repaFechaingreso;
    @Column(name = "REPA_FECHASALIDA")
    @Temporal(TemporalType.DATE)
    private Date repaFechasalida;
    @Size(max = 1200)
    @Column(name = "REPA_REPORTETECNICO")
    private String repaReportetecnico;
    @Column(name = "REPA_PRECIOMANOOBRA")
    private Integer repaPreciomanoobra;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "REPA_FALLA")
    private String repaFalla;
    @ManyToMany(mappedBy = "reparacionCollection")
    private Collection<Repuesto> repuestoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "repaIdNumorden")
    private Collection<Imagen> imagenCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "repaIdNumorden")
    private Collection<Garantia> garantiaCollection;
    @JoinColumn(name = "ART_ID", referencedColumnName = "ART_ID")
    @ManyToOne(optional = false)
    private Articulo artId;
    @JoinColumn(name = "EST_ID", referencedColumnName = "EST_ID")
    @ManyToOne(optional = false)
    private Estadoservicio estId;
    @JoinColumn(name = "TEC_ID", referencedColumnName = "TEC_ID")
    @ManyToOne(optional = false)
    private Tecnico tecId;

    public Reparacion() {
    }

    public Reparacion(Integer repaIdNumorden) {
        this.repaIdNumorden = repaIdNumorden;
    }

    public Integer getRepaIdNumorden() {
        return repaIdNumorden;
    }

    public void setRepaIdNumorden(Integer repaIdNumorden) {
        this.repaIdNumorden = repaIdNumorden;
    }

    public Date getRepaFechaingreso() {
        return repaFechaingreso;
    }

    public void setRepaFechaingreso(Date repaFechaingreso) {
        this.repaFechaingreso = repaFechaingreso;
    }

    public Date getRepaFechasalida() {
        return repaFechasalida;
    }

    public void setRepaFechasalida(Date repaFechasalida) {
        this.repaFechasalida = repaFechasalida;
    }

    public String getRepaReportetecnico() {
        return repaReportetecnico;
    }

    public void setRepaReportetecnico(String repaReportetecnico) {
        this.repaReportetecnico = repaReportetecnico;
    }

    public Integer getRepaPreciomanoobra() {
        return repaPreciomanoobra;
    }

    public void setRepaPreciomanoobra(Integer repaPreciomanoobra) {
        this.repaPreciomanoobra = repaPreciomanoobra;
    }

    public String getRepaFalla() {
        return repaFalla;
    }

    public void setRepaFalla(String repaFalla) {
        this.repaFalla = repaFalla;
    }

    @XmlTransient
    public Collection<Repuesto> getRepuestoCollection() {
        return repuestoCollection;
    }

    public void setRepuestoCollection(Collection<Repuesto> repuestoCollection) {
        this.repuestoCollection = repuestoCollection;
    }

    @XmlTransient
    public Collection<Imagen> getImagenCollection() {
        return imagenCollection;
    }

    public void setImagenCollection(Collection<Imagen> imagenCollection) {
        this.imagenCollection = imagenCollection;
    }

    @XmlTransient
    public Collection<Garantia> getGarantiaCollection() {
        return garantiaCollection;
    }

    public void setGarantiaCollection(Collection<Garantia> garantiaCollection) {
        this.garantiaCollection = garantiaCollection;
    }

    public Articulo getArtId() {
        return artId;
    }

    public void setArtId(Articulo artId) {
        this.artId = artId;
    }

    public Estadoservicio getEstId() {
        return estId;
    }

    public void setEstId(Estadoservicio estId) {
        this.estId = estId;
    }

    public Tecnico getTecId() {
        return tecId;
    }

    public void setTecId(Tecnico tecId) {
        this.tecId = tecId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (repaIdNumorden != null ? repaIdNumorden.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reparacion)) {
            return false;
        }
        Reparacion other = (Reparacion) object;
        if ((this.repaIdNumorden == null && other.repaIdNumorden != null) || (this.repaIdNumorden != null && !this.repaIdNumorden.equals(other.repaIdNumorden))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zeus.tallerelectronica.entidades.Reparacion[ repaIdNumorden=" + repaIdNumorden + " ]";
    }

    public String getRepaReportecliente() {
        return repaReportecliente;
    }

    public void setRepaReportecliente(String repaReportecliente) {
        this.repaReportecliente = repaReportecliente;
    }

    public Integer getRepaEstado() {
        return repaEstado;
    }

    public void setRepaEstado(Integer repaEstado) {
        this.repaEstado = repaEstado;
    }

    public String getRepaTipo() {
        return repaTipo;
    }

    public void setRepaTipo(String repaTipo) {
        this.repaTipo = repaTipo;
    }
    
}
