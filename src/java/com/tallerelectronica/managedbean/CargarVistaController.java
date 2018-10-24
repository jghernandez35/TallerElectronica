/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tallerelectronica.managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author AcerF5w10
 */
// Asi esta mapeado en Jefatura
@ManagedBean(name="cargarVistaController")


// ASi esta mapeado en Divsalud
//@Named(value = "cargarVistaController")
@SessionScoped

public class CargarVistaController implements Serializable {

    private String ruta;

    public String getRuta() {
        return ruta;
    }
    
    public CargarVistaController() {
        System.out.println("En Cargar Vista Controller /index.xhtml");
        this.ruta = "/index.xhtml";
    }
    
    public String CargarListaArticulos() {
        System.out.println("++++++ > En Controlador CargarVistaController Metodo CargarListaArticulos() = "+"faces/admin/articulo/List.xhtml");
        String a = new String();
        a = "/admin/articulo/List";
        return a;
        
        
    }
    public void CargarListaArticulos2() {
        System.out.println("******> En Controlador CargarVistaController Metodo CargarListaArticulos() = "+"faces/admin/articulo/List.xhtml");
        this.ruta = "/admin/articulo/List.xhtml";
        System.out.println("====="+ruta);
    }       
}
