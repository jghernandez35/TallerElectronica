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
 * @author AcerF5w10
 */
@Entity
@Table(name = "cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")
    , @NamedQuery(name = "Cliente.findByCliId", query = "SELECT c FROM Cliente c WHERE c.cliId = :cliId")
    , @NamedQuery(name = "Cliente.findByCliDocumento", query = "SELECT c FROM Cliente c WHERE c.cliDocumento = :cliDocumento")
    , @NamedQuery(name = "Cliente.findByCliNombres", query = "SELECT c FROM Cliente c WHERE c.cliNombres = :cliNombres")
    , @NamedQuery(name = "Cliente.findByCliApellidos", query = "SELECT c FROM Cliente c WHERE c.cliApellidos = :cliApellidos")
    , @NamedQuery(name = "Cliente.findByCliTelefono1", query = "SELECT c FROM Cliente c WHERE c.cliTelefono1 = :cliTelefono1")
    , @NamedQuery(name = "Cliente.findByCliTelefono2", query = "SELECT c FROM Cliente c WHERE c.cliTelefono2 = :cliTelefono2")
    , @NamedQuery(name = "Cliente.findByCliDireccion", query = "SELECT c FROM Cliente c WHERE c.cliDireccion = :cliDireccion")
    , @NamedQuery(name = "Cliente.findByCliLogin", query = "SELECT c FROM Cliente c WHERE c.cliLogin = :cliLogin")
    , @NamedQuery(name = "Cliente.findByCliContrasena", query = "SELECT c FROM Cliente c WHERE c.cliContrasena = :cliContrasena")
    , @NamedQuery(name = "Cliente.findByCliContactoaltnombre", query = "SELECT c FROM Cliente c WHERE c.cliContactoaltnombre = :cliContactoaltnombre")
    , @NamedQuery(name = "Cliente.findByCliContactoalttelefono", query = "SELECT c FROM Cliente c WHERE c.cliContactoalttelefono = :cliContactoalttelefono")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CLI_ID")
    private Integer cliId;
    @Column(name = "CLI_DOCUMENTO")
    private BigInteger cliDocumento;
    @Size(max = 30)
    @Column(name = "CLI_NOMBRES")
    private String cliNombres;
    @Size(max = 30)
    @Column(name = "CLI_APELLIDOS")
    private String cliApellidos;
    @Column(name = "CLI_TELEFONO1")
    private BigInteger cliTelefono1;
    @Column(name = "CLI_TELEFONO2")
    private BigInteger cliTelefono2;
    @Size(max = 70)
    @Column(name = "CLI_DIRECCION")
    private String cliDireccion;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "CLI_EMAIL")
    private String cliEmail;
    @Column(name = "CLI_LOGIN")
    private BigInteger cliLogin;
    @Column(name = "CLI_CONTRASENA")
    private BigInteger cliContrasena;
    @Size(max = 30)
    @Column(name = "CLI_CONTACTOALTNOMBRE")
    private String cliContactoaltnombre;
    @Column(name = "CLI_CONTACTOALTTELEFONO")
    private BigInteger cliContactoalttelefono;
    @JoinColumn(name = "TIPDOC_ID", referencedColumnName = "TIPDOC_ID")
    @ManyToOne(optional = false)
    private Tipodocumento tipdocId;
    @JoinColumn(name = "DEP_ID", referencedColumnName = "DEP_ID")
    @ManyToOne(optional = false)
    private Departamento depId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliId")
    private Collection<Articulo> articuloCollection;

    public Cliente() {
    }

    public Cliente(Integer cliId) {
        this.cliId = cliId;
    }

    public Integer getCliId() {
        return cliId;
    }

    public void setCliId(Integer cliId) {
        this.cliId = cliId;
    }

    public BigInteger getCliDocumento() {
        return cliDocumento;
    }

    public void setCliDocumento(BigInteger cliDocumento) {
        this.cliDocumento = cliDocumento;
    }

    public String getCliNombres() {
        return cliNombres;
    }

    public void setCliNombres(String cliNombres) {
        this.cliNombres = cliNombres;
    }

    public String getCliApellidos() {
        return cliApellidos;
    }

    public void setCliApellidos(String cliApellidos) {
        this.cliApellidos = cliApellidos;
    }

    public BigInteger getCliTelefono1() {
        return cliTelefono1;
    }

    public void setCliTelefono1(BigInteger cliTelefono1) {
        this.cliTelefono1 = cliTelefono1;
    }

    public BigInteger getCliTelefono2() {
        return cliTelefono2;
    }

    public void setCliTelefono2(BigInteger cliTelefono2) {
        this.cliTelefono2 = cliTelefono2;
    }

    public String getCliDireccion() {
        return cliDireccion;
    }

    public void setCliDireccion(String cliDireccion) {
        this.cliDireccion = cliDireccion;
    }

    public String getCliEmail() {
        return cliEmail;
    }

    public void setCliEmail(String cliEmail) {
        this.cliEmail = cliEmail;
    }

    public BigInteger getCliLogin() {
        return cliLogin;
    }

    public void setCliLogin(BigInteger cliLogin) {
        this.cliLogin = cliLogin;
    }

    public BigInteger getCliContrasena() {
        return cliContrasena;
    }

    public void setCliContrasena(BigInteger cliContrasena) {
        this.cliContrasena = cliContrasena;
    }

    public String getCliContactoaltnombre() {
        return cliContactoaltnombre;
    }

    public void setCliContactoaltnombre(String cliContactoaltnombre) {
        this.cliContactoaltnombre = cliContactoaltnombre;
    }

    public BigInteger getCliContactoalttelefono() {
        return cliContactoalttelefono;
    }

    public void setCliContactoalttelefono(BigInteger cliContactoalttelefono) {
        this.cliContactoalttelefono = cliContactoalttelefono;
    }

    public Tipodocumento getTipdocId() {
        return tipdocId;
    }

    public void setTipdocId(Tipodocumento tipdocId) {
        this.tipdocId = tipdocId;
    }

    public Departamento getDepId() {
        return depId;
    }

    public void setDepId(Departamento depId) {
        this.depId = depId;
    }

    @XmlTransient
    public Collection<Articulo> getArticuloCollection() {
        return articuloCollection;
    }

    public void setArticuloCollection(Collection<Articulo> articuloCollection) {
        this.articuloCollection = articuloCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cliId != null ? cliId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.cliId == null && other.cliId != null) || (this.cliId != null && !this.cliId.equals(other.cliId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zeus.tallerelectronica.entidades.Cliente[ cliId=" + cliId + " ]";
    }
    
}
