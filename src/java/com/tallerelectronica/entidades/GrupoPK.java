/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tallerelectronica.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author AcerF5w10
 */
@Embeddable
public class GrupoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "TEC_ID")
    private int tecId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ROL_ID")
    private int rolId;

    public GrupoPK() {
    }

    public GrupoPK(int tecId, int rolId) {
        this.tecId = tecId;
        this.rolId = rolId;
    }

    public int getTecId() {
        return tecId;
    }

    public void setTecId(int tecId) {
        this.tecId = tecId;
    }

    public int getRolId() {
        return rolId;
    }

    public void setRolId(int rolId) {
        this.rolId = rolId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) tecId;
        hash += (int) rolId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrupoPK)) {
            return false;
        }
        GrupoPK other = (GrupoPK) object;
        if (this.tecId != other.tecId) {
            return false;
        }
        if (this.rolId != other.rolId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tallerelectronica.entidades.GrupoPK[ tecId=" + tecId + ", rolId=" + rolId + " ]";
    }
    
}
