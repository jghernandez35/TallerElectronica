package com.tallerelectronica.entidades;

import com.tallerelectronica.entidades.Garantia;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2018-06-16T13:38:42")
@StaticMetamodel(Almacen.class)
public class Almacen_ { 

    public static volatile SingularAttribute<Almacen, Integer> almId;
    public static volatile SingularAttribute<Almacen, Integer> almEstado;
    public static volatile SingularAttribute<Almacen, String> almNombre;
    public static volatile CollectionAttribute<Almacen, Garantia> garantiaCollection;

}