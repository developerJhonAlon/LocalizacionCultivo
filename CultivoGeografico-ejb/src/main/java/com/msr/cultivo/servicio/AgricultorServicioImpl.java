/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.msr.cultivo.servicio;

import com.msr.cultivo.dto.AgricultorDTO;
import com.msr.cultivo.eis.AgricultorDAO;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Jhonny
 */
@Stateless
public class AgricultorServicioImpl implements AgricultorServicio{

    @Inject
    private AgricultorDAO agricultorDAO;
    
    @Override
    public boolean transGuardarAgricultor(AgricultorDTO agricultor) {
        return agricultorDAO.insertarAgricultor(agricultor);
    }

    @Override
    public List<AgricultorDTO> transListarAgricultores() {
        return agricultorDAO.listarAgricultores();
    }
    
    @Override
    public boolean transUpdateAgricultor(AgricultorDTO agricultor){
        return agricultorDAO.updateAgricultor(agricultor);
    }
    
    @Override
    public void transEliminarAgricultor(AgricultorDTO agricultor){
        agricultorDAO.eliminarAgricultor(agricultor);
    }
}
