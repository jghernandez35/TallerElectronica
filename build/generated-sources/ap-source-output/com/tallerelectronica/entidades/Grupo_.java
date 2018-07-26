package com.tallerelectronica.entidades;

import com.tallerelectronica.entidades.GrupoPK;
import com.tallerelectronica.entidades.Rol;
import com.tallerelectronica.entidades.Tecnico;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2018-06-16T13:38:42")
@StaticMetamodel(Grupo.class)
public class Grupo_ { 

    public static volatile SingularAttribute<Grupo, String> tecLogin;
    public static volatile SingularAttribute<Grupo, GrupoPK> grupoPK;
    public static volatile SingularAttribute<Grupo, Tecnico> tecnico;
    public static volatile SingularAttribute<Grupo, Rol> rol;

}