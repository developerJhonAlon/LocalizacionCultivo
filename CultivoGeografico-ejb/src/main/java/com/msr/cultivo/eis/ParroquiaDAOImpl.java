/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.msr.cultivo.eis;

import com.msr.cultivo.dto.ParroquiaDTO;
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
public class ParroquiaDAOImpl implements ParroquiaDAO {

    @PersistenceContext(unitName = "msrCultivoGeografico-ejb")
    private EntityManager em;

    @Override
    public List<ParroquiaDTO> listarParroquias() {
        Query qry = em.createQuery("SELECT b FROM ParroquiaDTO b");
        return qry.getResultList();

    }

    @Override
    public boolean insertarParroquia(ParroquiaDTO parroquia) {
        try {
            em.persist(parroquia);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(ParroquiaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean updateParroquia(ParroquiaDTO parroquia) {

        try {
            em.merge(parroquia);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(ParroquiaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public void eliminarParroquia(ParroquiaDTO parroquia) {
        parroquia = em.merge(parroquia);
        em.remove(parroquia);

    }

}