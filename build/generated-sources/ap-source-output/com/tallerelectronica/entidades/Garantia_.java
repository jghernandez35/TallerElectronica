package com.tallerelectronica.entidades;

import com.tallerelectronica.entidades.Almacen;
import com.tallerelectronica.entidades.Articulo;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2018-06-16T13:38:42")
@StaticMetamodel(Garantia.class)
public class Garantia_ { 

    public static volatile SingularAttribute<Garantia, String> garIdNumordenalmacen;
    public static volatile SingularAttribute<Garantia, Almacen> almId;
    public static volatile SingularAttribute<Garantia, Articulo> artIdNumorden;
    public static volatile SingularAttribute<Garantia, Integer> garId;

}