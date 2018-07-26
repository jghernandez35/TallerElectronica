package com.tallerelectronica.entidades;

import com.tallerelectronica.entidades.Articulo;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2018-06-16T13:38:42")
@StaticMetamodel(Marca.class)
public class Marca_ { 

    public static volatile SingularAttribute<Marca, Integer> marEstado;
    public static volatile SingularAttribute<Marca, String> marNombre;
    public static volatile CollectionAttribute<Marca, Articulo> articuloCollection;
    public static volatile SingularAttribute<Marca, Integer> marIdMarca;

}