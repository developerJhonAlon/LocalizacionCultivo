/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.msr.cultivo.eis;

import com.msr.cultivo.dto.BarrioDTO;
import com.msr.cultivo.dto.CultivoDTO;
import java.util.List;
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
        Query qry = em.createQuery("SELECT C FROM CultivoDTO c");
        return qry.getResultList();
    }
}
