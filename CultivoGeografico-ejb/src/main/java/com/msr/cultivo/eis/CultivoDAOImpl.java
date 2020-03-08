/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.msr.cultivo.eis;

import com.msr.cultivo.dto.BarrioDTO;
import com.msr.cultivo.dto.CultivoDTO;
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
public class CultivoDAOImpl implements CultivoDAO {

    @PersistenceContext(unitName = "msrCultivoGeografico-ejb")
    private EntityManager em;

    @Override
    public List<CultivoDTO> listarCultivos() {
        Query qry = em.createQuery("SELECT p FROM CultivoDTO p");
        return qry.getResultList();
    }

    @Override
    public boolean insertarCultivo(CultivoDTO cultivo) {
        try {
            em.persist(cultivo);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(CultivoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean updateCultivo(CultivoDTO cultivo) {
        try {
            em.merge(cultivo);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(CultivoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public void eliminarCultivo(CultivoDTO cultivo) {
        cultivo = em.merge(cultivo);
        em.remove(cultivo);

    }
}
