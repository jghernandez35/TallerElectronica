/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zeus.tallerelectronica.sessionbean;

import com.zeus.tallerelectronica.entidades.Repuesto;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author AcerF5w10
 */
@Stateless
public class RepuestoFacade extends AbstractFacade<Repuesto> {

    @PersistenceContext(unitName = "TallerElectronicaWebPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RepuestoFacade() {
        super(Repuesto.class);
    }
    
}
