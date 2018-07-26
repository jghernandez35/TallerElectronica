package com.tallerelectronica.entidades;

import com.tallerelectronica.entidades.Articulo;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2018-06-16T13:38:42")
@StaticMetamodel(Cliente.class)
public class Cliente_ { 

    public static volatile SingularAttribute<Cliente, String> cliApellidos;
    public static volatile SingularAttribute<Cliente, String> cliNombres;
    public static volatile SingularAttribute<Cliente, Integer> cliTelefono;
    public static volatile CollectionAttribute<Cliente, Articulo> articuloCollection;
    public static volatile SingularAttribute<Cliente, BigInteger> cliCelular;
    public static volatile SingularAttribute<Cliente, String> cliDireccion;
    public static volatile SingularAttribute<Cliente, Integer> cliId;
    public static volatile SingularAttribute<Cliente, BigInteger> cliCedula;

}