/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.msr.cultivo.eis;

import com.msr.cultivo.dto.AgricultorDTO;
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
public class AgricultorDAOImpl implements AgricultorDAO {
    
   @PersistenceContext(unitName = "msrCultivoGeografico-ejb")
   private EntityManager em;

    @Override
    public List<AgricultorDTO> listarAgricultores() {
        Query qry = em.createQuery("SELECT C FROM AgricultorDTO c");
        return qry.getResultList();
    }
   
    @Override
    public boolean insertarAgricultor(AgricultorDTO agricultor){
        try{
            em.persist(agricultor);
            return true;
        }catch(Exception ex){
            Logger.getLogger(AgricultorDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    
    }
    
    @Override
    public boolean updateAgricultor(AgricultorDTO agricultor){
        try{
            em.merge(agricultor);
            return true;
        }catch(Exception ex){
            Logger.getLogger(AgricultorDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    @Override
    public void eliminarAgricultor(AgricultorDTO agricultor){
           
        agricultor = em.merge(agricultor);
        em.remove(agricultor);
        
    }
          
       
        
    
    
   
   
   
}
