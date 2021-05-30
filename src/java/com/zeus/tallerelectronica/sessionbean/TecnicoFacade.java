/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zeus.tallerelectronica.sessionbean;

import com.zeus.tallerelectronica.entidades.Tecnico;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Usuario
 */
@Stateless
public class TecnicoFacade extends AbstractFacade<Tecnico> {

    @PersistenceContext(unitName = "TallerElectronicaWebPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TecnicoFacade() {
        super(Tecnico.class);
    }
    
    /*public boolean buscarPorEmail(String email) {
        Query query = getEntityManager().createNamedQuery("Usuario.findByEmail");
        query.setParameter("email", email);
        List<Tecnico> resultList = query.getResultList();
        if (resultList.size() > 0) {
            return true;
        } else {
            return false;
}
    }*/
    
    public boolean buscarTecnicoPorLoginBool(String tecLogin) {

        Query query = getEntityManager().createNamedQuery("Tecnico.findByTecLogin");
        query.setParameter("tecLogin", tecLogin);
        List<Tecnico> resultList = query.getResultList();
        if (resultList.size() > 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public Tecnico buscarPorLogin(String tecLogin) {

        Query query = getEntityManager().createNamedQuery("Tecnico.findByTecLogin");
        query.setParameter("tecLogin", tecLogin);
        List<Tecnico> resultList = query.getResultList();
        if (resultList.size() > 0) {
            return resultList.get(0)
                    ;
        } else {
            return null;
        }
    }    
    
    public boolean buscarPorNumeroIdentificacion(String tecCedula) {
        Query buscarIden = getEntityManager().createNamedQuery("Tecnico.findByTecCedula");
        buscarIden.setParameter("tecCedula", tecCedula);
        List<Tecnico> lista= buscarIden.getResultList();

        if(lista.size()==0){
            return false;
        }else{
           return true;
        }
    }
    
}
