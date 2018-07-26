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
    , @NamedQuery(name = "Cliente.findByCliCedula", query = "SELECT c FROM Cliente c WHERE c.cliCedula = :cliCedula")
    , @NamedQuery(name = "Cliente.findByCliNombres", query = "SELECT c FROM Cliente c WHERE c.cliNombres = :cliNombres")
    , @NamedQuery(name = "Cliente.findByCliApellidos", query = "SELECT c FROM Cliente c WHERE c.cliApellidos = :cliApellidos")
    , @NamedQuery(name = "Cliente.findByCliTelefono", query = "SELECT c FROM Cliente c WHERE c.cliTelefono = :cliTelefono")
    , @NamedQuery(name = "Cliente.findByCliCelular", query = "SELECT c FROM Cliente c WHERE c.cliCelular = :cliCelular")
    , @NamedQuery(name = "Cliente.findByCliDireccion", query = "SELECT c FROM Cliente c WHERE c.cliDireccion = :cliDireccion")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CLI_ID")
    private Integer cliId;
    @Column(name = "CLI_CEDULA")
    private BigInteger cliCedula;
    @Size(max = 30)
    @Column(name = "CLI_NOMBRES")
    private String cliNombres;
    @Size(max = 30)
    @Column(name = "CLI_APELLIDOS")
    private String cliApellidos;
    @Column(name = "CLI_TELEFONO")
    private Integer cliTelefono;
    @Column(name = "CLI_CELULAR")
    private BigInteger cliCelular;
    @Size(max = 70)
    @Column(name = "CLI_DIRECCION")
    private String cliDireccion;
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

    public BigInteger getCliCedula() {
        return cliCedula;
    }

    public void setCliCedula(BigInteger cliCedula) {
        this.cliCedula = cliCedula;
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

    public Integer getCliTelefono() {
        return cliTelefono;
    }

    public void setCliTelefono(Integer cliTelefono) {
        this.cliTelefono = cliTelefono;
    }

    public BigInteger getCliCelular() {
        return cliCelular;
    }

    public void setCliCelular(BigInteger cliCelular) {
        this.cliCelular = cliCelular;
    }

    public String getCliDireccion() {
        return cliDireccion;
    }

    public void setCliDireccion(String cliDireccion) {
        this.cliDireccion = cliDireccion;
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
        return "com.tallerelectronica.entidades.Cliente[ cliId=" + cliId + " ]";
    }
    
}
