/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tallerelectronica.entidades;

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
import javax.persistence.ManyToMany;
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
@Table(name = "tecnico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tecnico.findAll", query = "SELECT t FROM Tecnico t")
    , @NamedQuery(name = "Tecnico.findByTecId", query = "SELECT t FROM Tecnico t WHERE t.tecId = :tecId")
    , @NamedQuery(name = "Tecnico.findByTecCedula", query = "SELECT t FROM Tecnico t WHERE t.tecCedula = :tecCedula")
    , @NamedQuery(name = "Tecnico.findByTecNombres", query = "SELECT t FROM Tecnico t WHERE t.tecNombres = :tecNombres")
    , @NamedQuery(name = "Tecnico.findByTecApellidos", query = "SELECT t FROM Tecnico t WHERE t.tecApellidos = :tecApellidos")
    , @NamedQuery(name = "Tecnico.findByTecCelular", query = "SELECT t FROM Tecnico t WHERE t.tecCelular = :tecCelular")
    , @NamedQuery(name = "Tecnico.findByTecDireccion", query = "SELECT t FROM Tecnico t WHERE t.tecDireccion = :tecDireccion")
    , @NamedQuery(name = "Tecnico.findByTecLogin", query = "SELECT t FROM Tecnico t WHERE t.tecLogin = :tecLogin")
    , @NamedQuery(name = "Tecnico.findByTecContrasena", query = "SELECT t FROM Tecnico t WHERE t.tecContrasena = :tecContrasena")
    , @NamedQuery(name = "Tecnico.findByTecTipousuario", query = "SELECT t FROM Tecnico t WHERE t.tecTipousuario = :tecTipousuario")
    , @NamedQuery(name = "Tecnico.findByTecEstado", query = "SELECT t FROM Tecnico t WHERE t.tecEstado = :tecEstado")})
public class Tecnico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TEC_ID")
    private Integer tecId;
    @Column(name = "TEC_CEDULA")
    private BigInteger tecCedula;
    @Size(max = 30)
    @Column(name = "TEC_NOMBRES")
    private String tecNombres;
    @Size(max = 30)
    @Column(name = "TEC_APELLIDOS")
    private String tecApellidos;
    @Column(name = "TEC_CELULAR")
    private BigInteger tecCelular;
    @Size(max = 70)
    @Column(name = "TEC_DIRECCION")
    private String tecDireccion;
    @Size(max = 30)
    @Column(name = "TEC_LOGIN")
    private String tecLogin;
    @Size(max = 240)
    @Column(name = "TEC_CONTRASENA")
    private String tecContrasena;
    @Size(max = 20)
    @Column(name = "TEC_TIPOUSUARIO")
    private String tecTipousuario;
    @Column(name = "TEC_ESTADO")
    private Integer tecEstado;
    @JoinTable(name = "articulo_se_asigna_a_tecnico", joinColumns = {
        @JoinColumn(name = "TEC_ID", referencedColumnName = "TEC_ID")}, inverseJoinColumns = {
        @JoinColumn(name = "ART_ID_NUMORDEN", referencedColumnName = "ART_ID_NUMORDEN")})
    @ManyToMany
    private Collection<Articulo> articuloCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tecnico")
    private Collection<Grupo> grupoCollection;

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

    public BigInteger getTecCedula() {
        return tecCedula;
    }

    public void setTecCedula(BigInteger tecCedula) {
        this.tecCedula = tecCedula;
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

    public BigInteger getTecCelular() {
        return tecCelular;
    }

    public void setTecCelular(BigInteger tecCelular) {
        this.tecCelular = tecCelular;
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

    public String getTecTipousuario() {
        return tecTipousuario;
    }

    public void setTecTipousuario(String tecTipousuario) {
        this.tecTipousuario = tecTipousuario;
    }

    public Integer getTecEstado() {
        return tecEstado;
    }

    public void setTecEstado(Integer tecEstado) {
        this.tecEstado = tecEstado;
    }

    @XmlTransient
    public Collection<Articulo> getArticuloCollection() {
        return articuloCollection;
    }

    public void setArticuloCollection(Collection<Articulo> articuloCollection) {
        this.articuloCollection = articuloCollection;
    }

    @XmlTransient
    public Collection<Grupo> getGrupoCollection() {
        return grupoCollection;
    }

    public void setGrupoCollection(Collection<Grupo> grupoCollection) {
        this.grupoCollection = grupoCollection;
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
        return "com.tallerelectronica.entidades.Tecnico[ tecId=" + tecId + " ]";
    }
    
}
