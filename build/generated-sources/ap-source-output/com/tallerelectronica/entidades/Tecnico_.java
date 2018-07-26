package com.tallerelectronica.entidades;

import com.tallerelectronica.entidades.Articulo;
import com.tallerelectronica.entidades.Grupo;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2018-06-16T13:38:42")
@StaticMetamodel(Tecnico.class)
public class Tecnico_ { 

    public static volatile SingularAttribute<Tecnico, String> tecNombres;
    public static volatile CollectionAttribute<Tecnico, Grupo> grupoCollection;
    public static volatile SingularAttribute<Tecnico, Integer> tecEstado;
    public static volatile SingularAttribute<Tecnico, String> tecApellidos;
    public static volatile SingularAttribute<Tecnico, String> tecDireccion;
    public static volatile CollectionAttribute<Tecnico, Articulo> articuloCollection;
    public static volatile SingularAttribute<Tecnico, String> tecLogin;
    public static volatile SingularAttribute<Tecnico, String> tecContrasena;
    public static volatile SingularAttribute<Tecnico, String> tecTipousuario;
    public static volatile SingularAttribute<Tecnico, BigInteger> tecCedula;
    public static volatile SingularAttribute<Tecnico, Integer> tecId;
    public static volatile SingularAttribute<Tecnico, BigInteger> tecCelular;

}