package com.tallerelectronica.entidades;

import com.tallerelectronica.entidades.Cliente;
import com.tallerelectronica.entidades.Garantia;
import com.tallerelectronica.entidades.Marca;
import com.tallerelectronica.entidades.Reparacion;
import com.tallerelectronica.entidades.Tecnico;
import com.tallerelectronica.entidades.Tipoarticulo;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2018-06-16T13:38:42")
@StaticMetamodel(Articulo.class)
public class Articulo_ { 

    public static volatile SingularAttribute<Articulo, String> artObservaciones;
    public static volatile SingularAttribute<Articulo, String> artAccesorios;
    public static volatile SingularAttribute<Articulo, Date> artFechaingreso;
    public static volatile SingularAttribute<Articulo, String> artGarantia;
    public static volatile SingularAttribute<Articulo, Marca> marIdMarca;
    public static volatile SingularAttribute<Articulo, String> artFalla;
    public static volatile CollectionAttribute<Articulo, Reparacion> reparacionCollection;
    public static volatile SingularAttribute<Articulo, Integer> artIdNumorden;
    public static volatile SingularAttribute<Articulo, String> artSerial;
    public static volatile CollectionAttribute<Articulo, Tecnico> tecnicoCollection;
    public static volatile CollectionAttribute<Articulo, Garantia> garantiaCollection;
    public static volatile SingularAttribute<Articulo, Tipoarticulo> tipIdTipoArticulo;
    public static volatile SingularAttribute<Articulo, String> artModelo;
    public static volatile SingularAttribute<Articulo, Cliente> cliId;

}