/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zeus.tallerelectronica.sessionbean;

import com.zeus.tallerelectronica.entidades.Cliente;
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
public class ClienteFacade extends AbstractFacade<Cliente> {

    @PersistenceContext(unitName = "TallerElectronicaWebPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClienteFacade() {
        super(Cliente.class);
    }
    
    public boolean buscarPorNumeroIdentificacion(int cliCedula) {
        Query buscarIden = getEntityManager().createNamedQuery("Cliente.findByCliCedula");
        buscarIden.setParameter("cliCedula", cliCedula);
        List<Cliente> lista= buscarIden.getResultList();

        if(lista.size()==0){
            return false;
        }else{
           return true;
        }
    }      
}
