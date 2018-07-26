/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tallerelectronica.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "grupo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Grupo.findAll", query = "SELECT g FROM Grupo g")
    , @NamedQuery(name = "Grupo.findByTecId", query = "SELECT g FROM Grupo g WHERE g.grupoPK.tecId = :tecId")
    , @NamedQuery(name = "Grupo.findByRolId", query = "SELECT g FROM Grupo g WHERE g.grupoPK.rolId = :rolId")
    , @NamedQuery(name = "Grupo.findByTecLogin", query = "SELECT g FROM Grupo g WHERE g.tecLogin = :tecLogin")})
public class Grupo implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GrupoPK grupoPK;
    @Size(max = 30)
    @Column(name = "TEC_LOGIN")
    private String tecLogin;
    @JoinColumn(name = "TEC_ID", referencedColumnName = "TEC_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Tecnico tecnico;
    @JoinColumn(name = "ROL_ID", referencedColumnName = "ROL_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Rol rol;

    public Grupo() {
    }

    public Grupo(GrupoPK grupoPK) {
        this.grupoPK = grupoPK;
    }

    public Grupo(int tecId, int rolId) {
        this.grupoPK = new GrupoPK(tecId, rolId);
    }

    public GrupoPK getGrupoPK() {
        return grupoPK;
    }

    public void setGrupoPK(GrupoPK grupoPK) {
        this.grupoPK = grupoPK;
    }

    public String getTecLogin() {
        return tecLogin;
    }

    public void setTecLogin(String tecLogin) {
        this.tecLogin = tecLogin;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (grupoPK != null ? grupoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grupo)) {
            return false;
        }
        Grupo other = (Grupo) object;
        if ((this.grupoPK == null && other.grupoPK != null) || (this.grupoPK != null && !this.grupoPK.equals(other.grupoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tallerelectronica.entidades.Grupo[ grupoPK=" + grupoPK + " ]";
    }
    
}
