/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.msr.cultivo.servicio;

import com.msr.cultivo.dto.ProduccionDTO;
import com.msr.cultivo.eis.ProduccionDAO;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Jhonny
 */
@Stateless
public class ProduccionServicioImpl implements ProduccionServicio {

    @EJB
    private ProduccionDAO produccionDAO;
        
    @Override
    public boolean transGuardarProduccion(ProduccionDTO produccion) {
        return produccionDAO.insertarProduccion(produccion);
    }

    @Override
    public List<ProduccionDTO> transListarProducciones() {
       return produccionDAO.listarProducciones();

    }

    @Override
    public boolean transUpdateProduccion(ProduccionDTO produccion) {
        return produccionDAO.updateProduccion(produccion);

    }

    @Override
    public void transEliminarProduccion(ProduccionDTO produccion) {
        produccionDAO.eliminarProduccion(produccion);
    }
    
}
