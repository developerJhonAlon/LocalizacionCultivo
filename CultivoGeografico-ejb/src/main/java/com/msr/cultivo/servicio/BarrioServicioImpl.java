/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.msr.cultivo.servicio;

import com.msr.cultivo.dto.BarrioDTO;
import com.msr.cultivo.eis.BarrioDAO;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Kleber
 */
@Stateless
public class BarrioServicioImpl implements BarrioServicio{

    @EJB
    private BarrioDAO barrioDAO;
    
    @Override
    public List<BarrioDTO> transListarBarrios() {
      return barrioDAO.listarBarrios();  
    }

    @Override
    public boolean transGuardarBarrio(BarrioDTO barrio) {
        return barrioDAO.insertarBarrio(barrio);
    }

    @Override
    public boolean transUpdateBarrio(BarrioDTO barrio) {
        return barrioDAO.updateBarrio(barrio);
    }

    @Override
    public void transEliminaBarrio(BarrioDTO barrio) {
        barrioDAO.eliminarBarrio(barrio);
    }
    
}
