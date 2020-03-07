/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.msr.cultivo.servicio;

import com.msr.cultivo.dto.DetalleProduccionDTO;
import java.util.List;

/**
 *
 * @author Jhonny
 */
public interface DetalleProduccionServicio {
    
    public boolean transGuardarDetalleProduccion(DetalleProduccionDTO detalleProduccion);
    
    public List<DetalleProduccionDTO> transListarDetalleProducciones();
    
    public boolean transUpdateDetalleProduccion(DetalleProduccionDTO detalleProduccion);
    
    public void transEliminarDetalleProduccion(DetalleProduccionDTO detalleProduccion);
}
