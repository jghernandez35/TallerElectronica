/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zeus.tallerelectronica.sessionbean;

import com.zeus.tallerelectronica.entidades.Articulo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author AcerF5w10
 */
@Stateless
public class ArticuloFacade extends AbstractFacade<Articulo> {

    @PersistenceContext(unitName = "TallerElectronicaWebPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ArticuloFacade() {
        super(Articulo.class);
    }
    //busca los articulos asociados a un cliente mediante el id
    public List<Articulo> listarArticulosCliente(Integer cliId) {
        Query consulta=getEntityManager().createNamedQuery("Articulo.findByCliId");
        consulta.setParameter("cliId",cliId);
        List<Articulo> lista=consulta.getResultList();
        return lista;        
    }    
}
