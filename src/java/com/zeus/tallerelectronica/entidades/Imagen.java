/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zeus.tallerelectronica.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
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
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "imagen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Imagen.findAll", query = "SELECT i FROM Imagen i")
    , @NamedQuery(name = "Imagen.findByImgId", query = "SELECT i FROM Imagen i WHERE i.imgId = :imgId")
    , @NamedQuery(name = "Imagen.findByImgTipo", query = "SELECT i FROM Imagen i WHERE i.imgTipo = :imgTipo")})
public class Imagen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IMG_ID")
    private Integer imgId;
    @Lob
    @Column(name = "IMG_IMAGEN")
    private byte[] imgImagen;
    @Size(max = 255)
    @Column(name = "IMG_TIPO")
    private String imgTipo;
    @JoinColumn(name = "REPA_ID_NUMORDEN", referencedColumnName = "REPA_ID_NUMORDEN")
    @ManyToOne(optional = false)
    private Reparacion repaIdNumorden;

    public Imagen() {
    }

    public Imagen(Integer imgId) {
        this.imgId = imgId;
    }

    public Integer getImgId() {
        return imgId;
    }

    public void setImgId(Integer imgId) {
        this.imgId = imgId;
    }

    public byte[] getImgImagen() {
        return imgImagen;
    }

    public void setImgImagen(byte[] imgImagen) {
        this.imgImagen = imgImagen;
    }

    public String getImgTipo() {
        return imgTipo;
    }

    public void setImgTipo(String imgTipo) {
        this.imgTipo = imgTipo;
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
        hash += (imgId != null ? imgId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Imagen)) {
            return false;
        }
        Imagen other = (Imagen) object;
        if ((this.imgId == null && other.imgId != null) || (this.imgId != null && !this.imgId.equals(other.imgId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zeus.tallerelectronica.entidades.Imagen[ imgId=" + imgId + " ]";
    }
    
}
