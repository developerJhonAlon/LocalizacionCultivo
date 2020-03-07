/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.msr.cultivo.eis;

import com.msr.cultivo.dto.DetalleProduccionDTO;

/**
 *
 * @author Jhonny
 */
public interface DetalleProduccionDAO {
    public boolean insertarDetalleProduccion(DetalleProduccionDTO detalleProduccion);
    
    public boolean updateDetalleProduccion(DetalleProduccionDTO detalleProduccion);
    
    public void eliminarDetalleProduccion(DetalleProduccionDTO detalleProduccion);
}
