/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.msr.cultivo.servicio;

import com.msr.cultivo.dto.ParroquiaDTO;
import com.msr.cultivo.eis.ParroquiaDAO;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Jhonny
 */
@Stateless
public class ParroquiaServicioImpl implements ParroquiaServicio{
    
    @EJB
    private ParroquiaDAO parroquiaDAO;

    @Override
    public boolean transGuardarParroquia(ParroquiaDTO parroquia) {
        return parroquiaDAO.insertarParroquia(parroquia);
    }

    @Override
    public List<ParroquiaDTO> transListarParroquia() {
        return parroquiaDAO.listarParroquias();
    }

    @Override
    public boolean transUpdateParroquia(ParroquiaDTO parroquia) {
        return parroquiaDAO.updateParroquia(parroquia);
    }

    @Override
    public void transEliminarParroquia(ParroquiaDTO parroquia) {
        parroquiaDAO.eliminarParroquia(parroquia);
    }

   
    
}
