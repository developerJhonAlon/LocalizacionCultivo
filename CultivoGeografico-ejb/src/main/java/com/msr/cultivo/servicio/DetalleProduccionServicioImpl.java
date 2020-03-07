/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.msr.cultivo.servicio;

import com.msr.cultivo.dto.DetalleProduccionDTO;
import com.msr.cultivo.eis.DetalleProduccionDAO;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Jhonny
 */
@Stateless
public class DetalleProduccionServicioImpl implements DetalleProduccionServicio{
    
    @EJB
    private DetalleProduccionDAO detalleProduccionDAO;

    @Override
    public boolean transGuardarDetalleProduccion(DetalleProduccionDTO detalleProduccion) {
        return detalleProduccionDAO.insertarDetalleProduccion(detalleProduccion);
    }

    @Override
    public List<DetalleProduccionDTO> transListarDetalleProducciones() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean transUpdateDetalleProduccion(DetalleProduccionDTO detalleProduccion) {
        return detalleProduccionDAO.updateDetalleProduccion(detalleProduccion);
    }

    @Override
    public void transEliminarDetalleProduccion(DetalleProduccionDTO detalleProduccion) {
        detalleProduccionDAO.eliminarDetalleProduccion(detalleProduccion);
    }
}
