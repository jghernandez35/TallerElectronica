package com.tallerelectronica.entidades;

import com.tallerelectronica.entidades.Articulo;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2018-06-16T13:38:42")
@StaticMetamodel(Tipoarticulo.class)
public class Tipoarticulo_ { 

    public static volatile SingularAttribute<Tipoarticulo, Integer> tipEstado;
    public static volatile SingularAttribute<Tipoarticulo, String> tipNombre;
    public static volatile CollectionAttribute<Tipoarticulo, Articulo> articuloCollection;
    public static volatile SingularAttribute<Tipoarticulo, Integer> tipIdTipoArticulo;

}