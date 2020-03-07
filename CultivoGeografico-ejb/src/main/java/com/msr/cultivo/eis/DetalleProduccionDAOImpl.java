/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.msr.cultivo.eis;

import com.msr.cultivo.dto.DetalleProduccionDTO;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jhonny
 */
@Stateless
public class DetalleProduccionDAOImpl implements DetalleProduccionDAO{
    
    @PersistenceContext(unitName = "msrCultivoGeografico-ejb")
    private EntityManager em;
    
    @Override
    public boolean insertarDetalleProduccion(DetalleProduccionDTO detalleProduccion){
          try{
            em.persist(detalleProduccion);
            return true;
        }catch(Exception ex){
            Logger.getLogger(ProduccionDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    @Override
    public boolean updateDetalleProduccion(DetalleProduccionDTO detalleProduccion){
         try{
            em.merge(detalleProduccion);
            return true;
        }catch(Exception ex){
            Logger.getLogger(ProduccionDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    @Override
    public void eliminarDetalleProduccion(DetalleProduccionDTO detalleProduccion){
        detalleProduccion = em.merge(detalleProduccion);
        em.remove(detalleProduccion);

    }
    
}
