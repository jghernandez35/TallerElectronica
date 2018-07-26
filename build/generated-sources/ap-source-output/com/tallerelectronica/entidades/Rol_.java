package com.tallerelectronica.entidades;

import com.tallerelectronica.entidades.Grupo;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2018-06-16T13:38:42")
@StaticMetamodel(Rol.class)
public class Rol_ { 

    public static volatile SingularAttribute<Rol, Integer> rolId;
    public static volatile CollectionAttribute<Rol, Grupo> grupoCollection;
    public static volatile SingularAttribute<Rol, String> rolNombre;

}