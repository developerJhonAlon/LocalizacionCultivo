/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.msr.cultivo.eis;

import com.msr.cultivo.dto.BarrioDTO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Kleber
 */
@Stateless
public class BarrioDAOImpl implements BarrioDAO {

    @PersistenceContext(unitName = "msrCultivoGeografico-ejb")
    private EntityManager em;

    @Override
    public List<BarrioDTO> listarBarrios() {

        Query qry = em.createQuery("SELECT C FROM BarrioDTO c");
        return qry.getResultList();
    }

    @Override
    public boolean insertarBarrio(BarrioDTO barrio) {
        try {
            em.persist(barrio);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(ProduccionDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean updateBarrio(BarrioDTO barrio) {
        try {
            em.merge(barrio);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(BarrioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public void eliminarBarrio(BarrioDTO barrio) {
        barrio = em.merge(barrio);
        em.remove(barrio);
    }

}
