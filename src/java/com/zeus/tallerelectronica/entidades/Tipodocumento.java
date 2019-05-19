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
@Table(name = "tipodocumento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipodocumento.findAll", query = "SELECT t FROM Tipodocumento t")
    , @NamedQuery(name = "Tipodocumento.findByTipdocId", query = "SELECT t FROM Tipodocumento t WHERE t.tipdocId = :tipdocId")
    , @NamedQuery(name = "Tipodocumento.findByTipdocNombre", query = "SELECT t FROM Tipodocumento t WHERE t.tipdocNombre = :tipdocNombre")
    , @NamedQuery(name = "Tipodocumento.findByTipdocEstado", query = "SELECT t FROM Tipodocumento t WHERE t.tipdocEstado = :tipdocEstado")})
public class Tipodocumento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TIPDOC_ID")
    private Integer tipdocId;
    @Size(max = 30)
    @Column(name = "TIPDOC_NOMBRE")
    private String tipdocNombre;
    @Column(name = "TIPDOC_ESTADO")
    private Integer tipdocEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipdocId")
    private Collection<Tecnico> tecnicoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipdocId")
    private Collection<Cliente> clienteCollection;

    public Tipodocumento() {
    }

    public Tipodocumento(Integer tipdocId) {
        this.tipdocId = tipdocId;
    }

    public Integer getTipdocId() {
        return tipdocId;
    }

    public void setTipdocId(Integer tipdocId) {
        this.tipdocId = tipdocId;
    }

    public String getTipdocNombre() {
        return tipdocNombre;
    }

    public void setTipdocNombre(String tipdocNombre) {
        this.tipdocNombre = tipdocNombre;
    }

    public Integer getTipdocEstado() {
        return tipdocEstado;
    }

    public void setTipdocEstado(Integer tipdocEstado) {
        this.tipdocEstado = tipdocEstado;
    }

    @XmlTransient
    public Collection<Tecnico> getTecnicoCollection() {
        return tecnicoCollection;
    }

    public void setTecnicoCollection(Collection<Tecnico> tecnicoCollection) {
        this.tecnicoCollection = tecnicoCollection;
    }

    @XmlTransient
    public Collection<Cliente> getClienteCollection() {
        return clienteCollection;
    }

    public void setClienteCollection(Collection<Cliente> clienteCollection) {
        this.clienteCollection = clienteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipdocId != null ? tipdocId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipodocumento)) {
            return false;
        }
        Tipodocumento other = (Tipodocumento) object;
        if ((this.tipdocId == null && other.tipdocId != null) || (this.tipdocId != null && !this.tipdocId.equals(other.tipdocId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zeus.tallerelectronica.entidades.Tipodocumento[ tipdocId=" + tipdocId + " ]";
    }
    
}
