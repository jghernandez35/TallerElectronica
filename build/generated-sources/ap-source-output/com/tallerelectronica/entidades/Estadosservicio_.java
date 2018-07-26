package com.tallerelectronica.entidades;

import com.tallerelectronica.entidades.Reparacion;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2018-06-16T13:38:42")
@StaticMetamodel(Estadosservicio.class)
public class Estadosservicio_ { 

    public static volatile CollectionAttribute<Estadosservicio, Reparacion> reparacionCollection;
    public static volatile SingularAttribute<Estadosservicio, Integer> estId;
    public static volatile SingularAttribute<Estadosservicio, String> estNombre;
    public static volatile SingularAttribute<Estadosservicio, Integer> estEstado;

}