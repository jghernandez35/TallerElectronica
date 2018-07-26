package com.tallerelectronica.entidades;

import com.tallerelectronica.entidades.Articulo;
import com.tallerelectronica.entidades.Estadosservicio;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2018-06-16T13:38:42")
@StaticMetamodel(Reparacion.class)
public class Reparacion_ { 

    public static volatile SingularAttribute<Reparacion, Integer> repPrecio;
    public static volatile SingularAttribute<Reparacion, Estadosservicio> estId;
    public static volatile SingularAttribute<Reparacion, Articulo> artIdNumorden;
    public static volatile SingularAttribute<Reparacion, String> repReportetecnico;
    public static volatile SingularAttribute<Reparacion, Integer> repId;

}