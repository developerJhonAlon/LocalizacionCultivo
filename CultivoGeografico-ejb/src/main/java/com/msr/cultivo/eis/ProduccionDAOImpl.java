/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.msr.cultivo.eis;

import com.msr.cultivo.dto.ProduccionDTO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Jhonny
 */
@Stateless
public class ProduccionDAOImpl implements ProduccionDAO {

    @PersistenceContext(unitName = "msrCultivoGeografico-ejb")
    private EntityManager em;
    
    @Override
    public List<ProduccionDTO> listarProducciones() {
        Query qry = em.createQuery("SELECT p FROM ProduccionDTO p");
        return qry.getResultList();
    }

    @Override
    public boolean insertarProduccion(ProduccionDTO produccion) {
         try{
            em.persist(produccion);
            return true;
        }catch(Exception ex){
            Logger.getLogger(ProduccionDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean updateProduccion(ProduccionDTO produccion) {
         try{
            em.merge(produccion);
            return true;
        }catch(Exception ex){
            Logger.getLogger(ProduccionDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public void eliminarProduccion(ProduccionDTO produccion) {
        produccion = em.merge(produccion);
        em.remove(produccion);

    }
    
}
