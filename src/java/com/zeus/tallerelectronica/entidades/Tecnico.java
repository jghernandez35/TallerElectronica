/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zeus.tallerelectronica.entidades;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
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
@Table(name = "tecnico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tecnico.findAll", query = "SELECT t FROM Tecnico t")
    , @NamedQuery(name = "Tecnico.findByTecId", query = "SELECT t FROM Tecnico t WHERE t.tecId = :tecId")
    , @NamedQuery(name = "Tecnico.findByTecDocumento", query = "SELECT t FROM Tecnico t WHERE t.tecDocumento = :tecDocumento")
    , @NamedQuery(name = "Tecnico.findByTecNombres", query = "SELECT t FROM Tecnico t WHERE t.tecNombres = :tecNombres")
    , @NamedQuery(name = "Tecnico.findByTecApellidos", query = "SELECT t FROM Tecnico t WHERE t.tecApellidos = :tecApellidos")
    , @NamedQuery(name = "Tecnico.findByTecTelefono1", query = "SELECT t FROM Tecnico t WHERE t.tecTelefono1 = :tecTelefono1")
    , @NamedQuery(name = "Tecnico.findByTecTelefono2", query = "SELECT t FROM Tecnico t WHERE t.tecTelefono2 = :tecTelefono2")
    , @NamedQuery(name = "Tecnico.findByTecDireccion", query = "SELECT t FROM Tecnico t WHERE t.tecDireccion = :tecDireccion")
    , @NamedQuery(name = "Tecnico.findByTecLogin", query = "SELECT t FROM Tecnico t WHERE t.tecLogin = :tecLogin")
    , @NamedQuery(name = "Tecnico.findByTecContrasena", query = "SELECT t FROM Tecnico t WHERE t.tecContrasena = :tecContrasena")
    , @NamedQuery(name = "Tecnico.findByTecEstado", query = "SELECT t FROM Tecnico t WHERE t.tecEstado = :tecEstado")})
public class Tecnico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TEC_ID")
    private Integer tecId;
    @Column(name = "TEC_DOCUMENTO")
    private BigInteger tecDocumento;
    @Size(max = 30)
    @Column(name = "TEC_NOMBRES")
    private String tecNombres;
    @Size(max = 30)
    @Column(name = "TEC_APELLIDOS")
    private String tecApellidos;
    @Column(name = "TEC_TELEFONO1")
    private BigInteger tecTelefono1;
    @Column(name = "TEC_TELEFONO2")
    private BigInteger tecTelefono2;
    @Size(max = 70)
    @Column(name = "TEC_DIRECCION")
    private String tecDireccion;
    @Size(max = 30)
    @Column(name = "TEC_LOGIN")
    private String tecLogin;
    @Size(max = 240)
    @Column(name = "TEC_CONTRASENA")
    private String tecContrasena;
    @Column(name = "TEC_ESTADO")
    private Integer tecEstado;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "TEC_EMAIL")
    private String tecEmail;
    @Lob
    @Column(name = "TEC_IMAGEN")
    private byte[] tecImagen;
    @JoinTable(name = "tec_tiene_grupo", joinColumns = {
        @JoinColumn(name = "TEC_ID", referencedColumnName = "TEC_ID")}, inverseJoinColumns = {
        @JoinColumn(name = "ROL_ID", referencedColumnName = "ROL_ID")})
    @ManyToMany
    private Collection<Rol> rolCollection;
    @JoinColumn(name = "TIPDOC_ID", referencedColumnName = "TIPDOC_ID")
    @ManyToOne(optional = false)
    private Tipodocumento tipdocId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tecId")
    private Collection<Reparacion> reparacionCollection;

    public Tecnico() {
    }

    public Tecnico(Integer tecId) {
        this.tecId = tecId;
    }

    public Integer getTecId() {
        return tecId;
    }

    public void setTecId(Integer tecId) {
        this.tecId = tecId;
    }

    public BigInteger getTecDocumento() {
        return tecDocumento;
    }

    public void setTecDocumento(BigInteger tecDocumento) {
        this.tecDocumento = tecDocumento;
    }

    public String getTecNombres() {
        return tecNombres;
    }

    public void setTecNombres(String tecNombres) {
        this.tecNombres = tecNombres;
    }

    public String getTecApellidos() {
        return tecApellidos;
    }

    public void setTecApellidos(String tecApellidos) {
        this.tecApellidos = tecApellidos;
    }

    public BigInteger getTecTelefono1() {
        return tecTelefono1;
    }

    public void setTecTelefono1(BigInteger tecTelefono1) {
        this.tecTelefono1 = tecTelefono1;
    }

    public BigInteger getTecTelefono2() {
        return tecTelefono2;
    }

    public void setTecTelefono2(BigInteger tecTelefono2) {
        this.tecTelefono2 = tecTelefono2;
    }

    public String getTecDireccion() {
        return tecDireccion;
    }

    public void setTecDireccion(String tecDireccion) {
        this.tecDireccion = tecDireccion;
    }

    public String getTecLogin() {
        return tecLogin;
    }

    public void setTecLogin(String tecLogin) {
        this.tecLogin = tecLogin;
    }

    public String getTecContrasena() {
        return tecContrasena;
    }

    public void setTecContrasena(String tecContrasena) {
        this.tecContrasena = tecContrasena;
    }

    public Integer getTecEstado() {
        return tecEstado;
    }

    public void setTecEstado(Integer tecEstado) {
        this.tecEstado = tecEstado;
    }

    public String getTecEmail() {
        return tecEmail;
    }

    public void setTecEmail(String tecEmail) {
        this.tecEmail = tecEmail;
    }

    public byte[] getTecImagen() {
        return tecImagen;
    }

    public void setTecImagen(byte[] tecImagen) {
        this.tecImagen = tecImagen;
    }

    @XmlTransient
    public Collection<Rol> getRolCollection() {
        return rolCollection;
    }

    public void setRolCollection(Collection<Rol> rolCollection) {
        this.rolCollection = rolCollection;
    }

    public Tipodocumento getTipdocId() {
        return tipdocId;
    }

    public void setTipdocId(Tipodocumento tipdocId) {
        this.tipdocId = tipdocId;
    }

    @XmlTransient
    public Collection<Reparacion> getReparacionCollection() {
        return reparacionCollection;
    }

    public void setReparacionCollection(Collection<Reparacion> reparacionCollection) {
        this.reparacionCollection = reparacionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tecId != null ? tecId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tecnico)) {
            return false;
        }
        Tecnico other = (Tecnico) object;
        if ((this.tecId == null && other.tecId != null) || (this.tecId != null && !this.tecId.equals(other.tecId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zeus.tallerelectronica.entidades.Tecnico[ tecId=" + tecId + " ]";
    }
    
}
